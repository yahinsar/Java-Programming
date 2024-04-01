package main.java.ru.sgu;

class AirConditioner extends AbstractSmartDevice implements SmartDevice {
    private int temperature = 25;

    public AirConditioner(String deviceId, String wifiName, boolean isTurnedOn) {
        super(deviceId, wifiName, isTurnedOn);
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