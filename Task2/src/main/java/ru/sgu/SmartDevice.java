package main.java.ru.sgu;

interface SmartDevice {
    void turnOn();
    void turnOff();
    boolean isOn();
    String getDeviceName(); // новый метод
}