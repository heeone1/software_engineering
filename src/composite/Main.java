package composite;

import java.util.ArrayList;
import java.util.List;

// Component interface
interface FileSystemComponent {
    void showDetails();
}

// Leaf class (개별 객체 = 밑에 자식 가질 수 없음)
class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}

// Composite class(합성 객체 = 복합 객체 )
class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>(); //자식 객체를 담을 컬랙션

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() { //재귀적으로 자식 객체의 showDetails() 메서드 호출
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) { //components = Arraylist
            component.showDetails();
        }
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component); //자식 제거
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        //단일 객체 2개 생성
        //트리 구조 생성 
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        //디렉터리객체 생성
        Directory dir1 = new Directory("dir1");
        dir1.addComponent(file1); //dir1 밑에 자식으로 file1 추가

        Directory dir2 = new Directory("dir2");
        dir2.addComponent(file2);
        dir2.addComponent(dir1);

        dir2.showDetails(); //트리 구조 출력
    }
}