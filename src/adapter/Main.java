package adapter;

// Target interface(클라이언트가 사용할 인터페이스)
interface Socket {
    String getOutput();
}

// Adaptee class
class EuropeanSocket {
    public String getEuropeanOutput() { //일자 모양 소켓
        return "220V";
    }
}

// Adapter class
class SocketAdapter implements Socket {
    private EuropeanSocket europeanSocket; //Adaptee객체를 항상 포함하고 있어야지 얘한테 일 시킬 수 있음

    public SocketAdapter(EuropeanSocket europeanSocket) {
        this.europeanSocket = europeanSocket;
    }

    @Override
    public String getOutput() { //원형 모양 소켓
        return europeanSocket.getEuropeanOutput(); //Adaptee 메서드 호출(위임)
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        EuropeanSocket europeanSocket = new EuropeanSocket(); //일자 모양 소켓
        
        Socket socketAdapter = new SocketAdapter(europeanSocket); //SocketAdapter가 원형 모양 소켓으로 변환
        
        System.out.println("Socket output: " + socketAdapter.getOutput());//Target Interface의 메서드 호출
    }
}