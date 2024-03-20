package main.java.ru.sgu;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<SmartDevice> devices = new ArrayList<>();

        AirConditioner ac = new AirConditioner();
        DoorLock doorLock = new DoorLock();
        Lamp lamp = new Lamp();

        devices.add(ac);
        devices.add(doorLock);
        devices.add(lamp);

        System.out.println("\nВключим все устройства: ");
        for (SmartDevice device : devices) {
            device.turnOn();
        }

        System.out.println("\nВыключим все устройства: ");
        for (SmartDevice device : devices) {
            device.turnOff();
        }
        System.out.println("\n");

        ac.setTemperature(20);
        System.out.println("Текущая температура: " + ac.getTemperature() + "°C");


        doorLock.lock();
        System.out.println("Проверка, заперта ли дверь: " + doorLock.isLocked());


        lamp.setColor("Фиолетовый");
        System.out.println("Цвет лампы: " + lamp.getColor());
    }
}