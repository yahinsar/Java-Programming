package main.java.ru.sgu;

class DoorLock extends AbstractSmartDevice implements SmartDevice {
    private boolean isLocked = false;

    public DoorLock(String deviceId, String wifiName, boolean isTurnedOn) {
        super(deviceId, wifiName, isTurnedOn);
    }

    public void lock() {
        isLocked = true;
        System.out.println("Вы заперли дверь " + getDeviceID() + ".");
    }

    public void unlock() {
        isLocked = false;
        System.out.println("Вы открыли дверь " + getDeviceID() + ".");
    }

    public boolean isLocked() {
        return isLocked;
    }

    @Override
    public String getDeviceName() {
        return "Дверной замок";
    }
}