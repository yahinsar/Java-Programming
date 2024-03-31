package main.java.ru.sgu;

import java.util.Objects;

class AirConditioner extends AbstractSmartDevice implements SmartDevice {
    private int temperature = 25;

    public AirConditioner(String deviceId) {
        super(deviceId);
    }

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