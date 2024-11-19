package proxy;

// Subject interface
interface Image {
    void display();
}

// RealSubject class
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

// Proxy class
class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {// display 요청이 오면 생성, 필요 없을 때 미리 만들어두면 비효율임
        if (realImage == null) { //RealSubject가 아직 생성되지 않았다면 
            realImage = new RealImage(fileName); //여기서 RealSubject가 생성함
        }
        realImage.display(); //RealSubject가 이미 생성되어 있다면 바로 display호출
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Image image0 = new RealImage("photo0.jpg"); //이렇게 직접 생성하면 생성시간 오래 걸림 
        //이 객체에 display() 메서드를 호출하지 않아도 이미지가 로드됨 -> 불필요한 시간 소모되는 거임 

        Image image1 = new ProxyImage("photo1.jpg"); //따라서 직적 생성하지 않고, proxy를 호출해서 필요할 때만 이미지를 로드 
        Image image2 = new ProxyImage("photo2.jpg");

        // Image will be loaded from disk
        image1.display();
        System.out.println("");

        // Image will not be loaded from disk
        image1.display();
        System.out.println("");

        // Image will be loaded from disk
        image2.display();
        System.out.println("");

        // Image will not be loaded from disk
        image2.display();
    }
}