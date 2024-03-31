package main.java.ru.sgu;

import java.util.Objects;

class DoorLock extends AbstractSmartDevice implements SmartDevice {
    private boolean isLocked = false;

    public DoorLock(String deviceId) {
        super(deviceId);
    }

    public void lock() {
        isLocked = true;
        System.out.println("Вы заперли дверь.");
    }

    public void unlock() {
        isLocked = false;
        System.out.println("Вы открыли дверь.");
    }

    public boolean isLocked() {
        return isLocked;
    }

    @Override
    public String getDeviceName() {
        return "Дверной замок";
    }
}