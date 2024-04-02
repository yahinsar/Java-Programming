package main.java.ru.sgu;

import java.io.Serializable;
import java.util.Objects;

abstract class AbstractSmartDevice implements SmartDevice, Comparable <AbstractSmartDevice>, Cloneable, Serializable {
    private String deviceId;
    private String wifiName;
    private boolean isTurnedOn;

    public AbstractSmartDevice(String deviceId, String wifiName, boolean isTurnedOn) {
        setAbstractSmartDevice(deviceId, wifiName, isTurnedOn);
    }

    public void turnOn() {
        isTurnedOn = true;
        System.out.println("Включено устройство \"" + getDeviceName() + "\" (ID: " + deviceId + ")");
    }

    public void turnOff() {
        isTurnedOn = false;
        System.out.println("Выключено устройство \"" + getDeviceName() + "\" (ID: " + deviceId + ")");
    }

    public String getDeviceID() {
        return deviceId;
    }

    public String getWifiName() {
        return wifiName;
    }

    public void setDeviceID(String deviceID) {
        if (deviceID == null) {
            throw new IllegalArgumentException("Ошибка: передано пустое значение.");
        }
        this.deviceId = deviceID;
    }

    public void setWifiName(String wifiName) {
        if (wifiName == null) {
            throw new IllegalArgumentException("Ошибка: передано пустое значение.");
        }
        this.wifiName = wifiName;
    }

    public void setAbstractSmartDevice(String deviceID, String wifiName, boolean isTurnedOn) {
        if (deviceID == null || wifiName == null) {
            throw new IllegalArgumentException("Ошибка: передано пустое значение.");
        }
        setDeviceID(deviceID);
        setWifiName(wifiName);
        this.isTurnedOn = isTurnedOn;
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
        return isTurnedOn == that.isTurnedOn &&
                Objects.equals(deviceId, that.deviceId) &&
                Objects.equals(wifiName, that.wifiName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isTurnedOn, deviceId, wifiName);
    }

    @Override
    public int compareTo(AbstractSmartDevice device) {
        int onComparison = Boolean.compare(this.isOn(), device.isOn());
        if (onComparison != 0) {
            return onComparison;
        } else {
            int deviceIDComparison = this.deviceId.compareTo(device.deviceId);
            if (deviceIDComparison != 0) {
                return deviceIDComparison;
            } else {
                return this.wifiName.compareTo(device.wifiName);
            }
        }
    }

    @Override
    public String toString() {
        return "AbstractSmartDevice{" +
                "isTurnedOn=" + isTurnedOn +
                ", deviceId='" + deviceId + '\'' +
                ", wifiName='" + wifiName + '\'' +
                '}';
    }

    public AbstractSmartDevice deepCopy() {
        try {
            AbstractSmartDevice copy = (AbstractSmartDevice) super.clone();
            //У меня нет объектов других классов и массивов, поэтому тут ничего нет, а так я бы создал новые ссылки тут на них
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}