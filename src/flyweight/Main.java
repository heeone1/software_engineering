package flyweight;

import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface Shape {
    void draw();
}

// Concrete Flyweight class
class Circle implements Shape {
    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle [Color: " + color + ", x: " + x + ", y: " + y + ", radius: " + radius + "]");
    }
}

// Flyweight Factory
class ShapeFactory {
    private static final Map<String, Shape> circleMap = new HashMap<>(); //키-값 쌍으로 저장

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color); //이미 이 색깔로 생성된 Circle 객체가인지 확인

        if (circle == null) { //생성된 객체가 없가면 새로 생성
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color: " + color);
        }
        return circle;
    }
}

// Client code
public class Main {
    private static final String[] colors = {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {

            //Circle 객체를 직접 생성하지 않고, FLyweight Factory 을 통해서 함 
            //직접 생성을 했다면, 동일한 색깔 정보는 계속 반복되어 생성됨 
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    private static int getRandomX() {
        return (int) (Math.random() * 100);
    }

    private static int getRandomY() {
        return (int) (Math.random() * 100);
    }
}