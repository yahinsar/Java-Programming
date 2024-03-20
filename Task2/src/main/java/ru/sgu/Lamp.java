package main.java.ru.sgu;

class Lamp extends AbstractSmartDevice {
    private String color = "Белый";

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