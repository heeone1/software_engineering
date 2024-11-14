package bridge;

// Implementor interface
interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int volume);
}

// Concrete Implementor 1
class TV implements Device {
    private int volume;

    @Override
    public void turnOn() {
        System.out.println("Turning on the TV.");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off the TV.");
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Setting TV volume to " + volume);
    }
}

// Concrete Implementor 2
class Radio implements Device {
    private int volume;

    @Override
    public void turnOn() {
        System.out.println("Turning on the Radio.");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off the Radio.");
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Setting Radio volume to " + volume);
    }
}

// Abstraction
abstract class RemoteControl {
    protected Device device;

    protected RemoteControl(Device device) {
        this.device = device;
    }

    //기능의 종류를 선언
    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void setVolume(int volume);
}

// Refined Abstraction
class BasicRemoteControl extends RemoteControl {
    public BasicRemoteControl(Device device) {
        super(device);
    }

    //리모컨은 모든일 구현 객체(장치=device)에 위임
    @Override
    public void turnOn() {
        device.turnOn();
    }

    @Override
    public void turnOff() {
        device.turnOff();
    }

    @Override
    public void setVolume(int volume) {
        device.setVolume(volume);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Device tv = new TV(); //구현 객체   
        RemoteControl tvRemote = new BasicRemoteControl(tv); //리모컨 기능의 종류를 나타내는 객체

        // RemoteControl tvRemote2 = new BasicRemoteControl(tv2)

        //실제 일은 리모컨이 하지 않고, 리모컨이 가지고 있는 구현 객체에게 위임함
        tvRemote.turnOn();
        tvRemote.setVolume(10);
        tvRemote.turnOff();

        Device radio = new Radio(); //구현 객체 생성
        RemoteControl radioRemote = new BasicRemoteControl(radio);
        //리모컨 버튼을 누르면, 라디오가 실제로 일을 함 
        radioRemote.turnOn();
        radioRemote.setVolume(5);
        radioRemote.turnOff();
    }
}