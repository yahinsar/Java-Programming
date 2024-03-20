package main.java.ru.sgu;

class DoorLock extends AbstractSmartDevice {
    private boolean isLocked = false;

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