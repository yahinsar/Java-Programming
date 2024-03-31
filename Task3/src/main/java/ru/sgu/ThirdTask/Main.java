package main.java.ru.sgu.ThirdTask;

public class Main {
    public static void main(String[] args) {
        SmartHomeMediator mediator = new SmartHomeMediator();

        Lamp lamp = new Lamp(mediator);
        DoorLock doorLock = new DoorLock(mediator);
        AirConditioner airConditioner = new AirConditioner(mediator);

        mediator.addDevice(lamp);
        mediator.addDevice(doorLock);
        mediator.addDevice(airConditioner);

        System.out.println();
        //Домой пришли
        doorLock.open();
        System.out.println();
        //Из дома ушли
        doorLock.close();
    }
}