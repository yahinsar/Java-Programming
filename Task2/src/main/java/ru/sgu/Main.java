package main.java.ru.sgu;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //общие проверки
        String wifiNet = "tp-link";
        List<SmartDevice> devices = new ArrayList<>();

        AirConditioner ac = new AirConditioner("AC1", wifiNet, false);
        AirConditioner ac2 = new AirConditioner("AC2", wifiNet, false);
        AirConditioner ac3 = new AirConditioner("AC1", wifiNet, false);
        DoorLock doorLock = new DoorLock("DL1", wifiNet, false);
        Lamp lamp = new Lamp("L1", wifiNet, false);

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
        System.out.println("Проверка, заперта ли дверь " + doorLock.getDeviceID() + ": " + doorLock.isLocked());

        lamp.setColor("Фиолетовый");
        System.out.println("Цвет лампы " + lamp.getDeviceID() + ": " + lamp.getColor());


        // Проверка equals
        System.out.println("\n\nПроверка equals:");
        System.out.println("\nСравниваем ac и ac2 (разные):");
        System.out.println("ac.equals(ac2): " + ac.equals(ac2));
        System.out.println("\nСравниваем ac и ac3 (одинаковые):");
        System.out.println("ac.equals(ac3): " + ac.equals(ac3));

        // Проверка hashCode
        System.out.println("\nПроверка hashCode:");
        System.out.println("ac.hashCode(): " + ac.hashCode());
        System.out.println("ac2.hashCode(): " + ac2.hashCode());
        System.out.println("ac3.hashCode(): " + ac3.hashCode());

        // Проверка compareTo
        System.out.println("\nПроверка compareTo:");
        System.out.println("ac.compareTo(ac2): " + ac.compareTo(ac2));
        System.out.println("ac.compareTo(ac3): " + ac.compareTo(ac3));

        // Проверка toString
        System.out.println("\nПроверка toString:");
        System.out.println("ac.toString(): " + ac.toString());
        System.out.println("ac2.toString(): " + ac2.toString());

        System.out.println("\nПроверка поверхностной копии (acShallowCopy зависит от ac и наоборот, а acDeepCopy не зависит):");
        System.out.println("\nДо изменений:");
        System.out.println("Оригинальный объект:");
        System.out.println(ac);
        AbstractSmartDevice acShallowCopy = ac;
        AbstractSmartDevice acDeepCopy = ac.deepCopy();
        acShallowCopy.setDeviceID("001-NEW");
        ac.setWifiName("beeline");
        System.out.println("\nПосле изменений:");
        System.out.println("Оригинальный объект:");
        System.out.println(ac);
        System.out.println("\nПоверхностная копия:");
        System.out.println(acShallowCopy);
        System.out.println("\nГлубокая копия:");
        System.out.println(acDeepCopy);
    }
}