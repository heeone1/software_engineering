package decorator;

// Component interface
interface Coffee {
    String getDescription();
    double getCost();
}

// Concrete Component
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple coffee";
    }

    @Override
    public double getCost() {
        return 2.0;
    }
}

// Base Decorator
abstract class CoffeeDecorator implements Coffee { //모든 장식자의 부모 클래스
    protected Coffee decoratedCoffee; //장식 대상

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// Concrete Decorator 1
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.5;
    }
}

// Concrete Decorator 2
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.2;
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee(); //가운데 심
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        coffee = new MilkDecorator(coffee); //우유로 장식
        System.out.println(coffee.getDescription() + " $" + coffee.getCost()); //우유 가격이 추가

        coffee = new SugarDecorator(coffee);//설탕으로 장식
        System.out.println(coffee.getDescription() + " $" + coffee.getCost()); //설탕 가격이 추가
    
        coffee = new SugarDecorator(new MilkDecorator(new SugarDecorator(new SimpleCoffee())));
        System.out.println(coffee.getDescription() + " $" + coffee.getCost()); 
    }
}