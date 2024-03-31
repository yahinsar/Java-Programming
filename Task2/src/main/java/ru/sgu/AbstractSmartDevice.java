package main.java.ru.sgu;

import java.util.Objects;

abstract class AbstractSmartDevice implements SmartDevice, Comparable <AbstractSmartDevice>, Cloneable {
    private final String deviceId;
    private boolean isTurnedOn;
    public AbstractSmartDevice(String deviceId) {
        this.deviceId = deviceId;
    }

    public void turnOn() {
        isTurnedOn = true;
        System.out.println("Включено устройство \"" + getDeviceName() + "\"");
    }

    public void turnOff() {
        isTurnedOn = false;
        System.out.println("Выключено устройство \"" + getDeviceName() + "\"");
    }

    public String getDeviceID() {
        return deviceId;
    }

    public boolean isOn() {
        return isTurnedOn;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        AbstractSmartDevice that = (AbstractSmartDevice) obj;
        return isTurnedOn == that.isTurnedOn && Objects.equals(deviceId, that.deviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isTurnedOn, deviceId);
    }

    @Override
    public int compareTo(AbstractSmartDevice device) {
        int onComparison = Boolean.compare(this.isOn(), device.isOn());
        if (onComparison != 0) {
            return onComparison;
        } else {
            return this.deviceId.compareTo(device.deviceId);
        }
    }

    @Override
    public String toString() {
        return "AbstractSmartDevice{" +
                "isTurnedOn=" + isTurnedOn +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public AbstractSmartDevice shallowCopy() throws CloneNotSupportedException {
        return (AbstractSmartDevice) clone();
    }

    //public AbstractSmartDevice deepCopy() { }
}
