package prototype;

class Employee implements Cloneable { //복제 가능한 객체로 만들기 위해 Cloneable 인터페이스를 구현 
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public Employee clone() { //자기 복제 메소드
        try {
            return (Employee) super.clone(); // Object.clone() 이 호출됨 //super은 부모를 의미함, 부모 클래스 없으면 object가 부모임
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void introduce() {
        System.out.println("Hi, my name is " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee originalEmployee = new Employee("John Doe"); //원본 객체

        Employee clonedEmployee = originalEmployee.clone();//원복 객체를 복제해서 새로운 객체를 생성
        // clonedEmployee.setName("hee") //원복 객체에서 이름만 바꿔서 새로운 객체 생성 

        originalEmployee.introduce(); // Output: Hi, my name is John Doe
        clonedEmployee.introduce();   // Output: Hi, my name is John Doe
    }
}