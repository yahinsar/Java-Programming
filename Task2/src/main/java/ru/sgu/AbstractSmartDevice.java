package main.java.ru.sgu;
abstract class AbstractSmartDevice implements SmartDevice {
    private boolean isTurnedOn;

    public void turnOn() {
        isTurnedOn = true;
        System.out.println("Включено устройство \"" + getDeviceName() + "\"");
    }

    public void turnOff() {
        isTurnedOn = false;
        System.out.println("Выключено устройство \"" + getDeviceName() + "\"");
    }

    public boolean isOn() {
        return isTurnedOn;
    }
}
