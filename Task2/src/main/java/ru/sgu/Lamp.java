package main.java.ru.sgu;

class Lamp extends AbstractSmartDevice implements SmartDevice {
    private String color = "Белый";

    public Lamp(String deviceId, String wifiName, boolean isTurnedOn) {
        super(deviceId, wifiName, isTurnedOn);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String getDeviceName() {
        return "Лампа";
    }
}