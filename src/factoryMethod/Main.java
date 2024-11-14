package factoryMethod;

// Product interface
interface Animal {
    void speak();
}

// Concrete Product 1
class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }
}

// Concrete Product 2
class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("Meow!");
    }
}

// Creator abstract class
abstract class AnimalFactory { //부모클래스
    // Factory Method
    public abstract Animal createAnimal(); //팩토리 메서드

    public void makeAnimalSpeak() {
        Animal animal = createAnimal(); //동물 생성 
        animal.speak(); //speak
    }
}

// Concrete Creator 1
class DogFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

// Concrete Creator 2
class CatFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        //생성 관련 패턴은 new Dog 이런식으로 직접 생성하지 않음 
        AnimalFactory dogFactory = new DogFactory();
        dogFactory.makeAnimalSpeak(); // Output: Woof!

        AnimalFactory catFactory = new CatFactory();
        catFactory.makeAnimalSpeak(); // Output: Meow!
    }
}