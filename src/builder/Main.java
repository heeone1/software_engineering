package builder;

// Product class
class House {
    private String foundation;
    private String structure;
    private String roof;

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    @Override
    public String toString() {
        return "House [foundation=" + foundation + ", structure=" + structure + ", roof=" + roof + "]";
    }
}

// Builder interface
interface HouseBuilder {
    void buildFoundation();
    void buildStructure();
    void buildRoof();

    House getHouse(); //완제품 반환
}

// Concrete Builder 1
class WoodenHouseBuilder implements HouseBuilder {
    private House house;

    public WoodenHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildFoundation() {
        house.setFoundation("Wooden foundation");
        System.out.println("WoodenHouseBuilder: Foundation complete...");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Wooden structure");
        System.out.println("WoodenHouseBuilder: Structure complete...");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Wooden roof");
        System.out.println("WoodenHouseBuilder: Roof complete...");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}

// Concrete Builder 2
class BrickHouseBuilder implements HouseBuilder {
    private House house;

    public BrickHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildFoundation() {
        house.setFoundation("Brick foundation");
        System.out.println("BrickHouseBuilder: Foundation complete...");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Brick structure");
        System.out.println("BrickHouseBuilder: Structure complete...");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Brick roof");
        System.out.println("BrickHouseBuilder: Roof complete...");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}

// Director = Builder이용해서 일 시키는 것 
class ConstructionEngineer {
    private HouseBuilder houseBuilder;

    public ConstructionEngineer(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse() {
        this.houseBuilder.buildFoundation();
        this.houseBuilder.buildStructure();
        this.houseBuilder.buildRoof();
        return this.houseBuilder.getHouse();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        //나무집
        HouseBuilder woodenHouseBuilder = new WoodenHouseBuilder();
        ConstructionEngineer engineer1 = new ConstructionEngineer(woodenHouseBuilder);
        House woodenHouse = engineer1.constructHouse();
        System.out.println("House is: " + woodenHouse);

        //벽돌집
        HouseBuilder brickHouseBuilder = new BrickHouseBuilder();
        ConstructionEngineer engineer2 = new ConstructionEngineer(brickHouseBuilder);
        House brickHouse = engineer2.constructHouse();
        System.out.println("House is: " + brickHouse);
    }
}