package main.java.ru.sgu;

class AirConditioner extends AbstractSmartDevice {
    private int temperature = 25;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public String getDeviceName() {
        return "Кондиционер";
    }
}