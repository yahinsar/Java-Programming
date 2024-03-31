package main.java.ru.sgu.ThirdTask;

import java.util.ArrayList;
import java.util.List;

class SmartHomeMediator implements Mediator {
    private List<SmartDevice> devices = new ArrayList<>();

    public void addDevice(SmartDevice device) {
        devices.add(device);
    }

    @Override
    public void notify(SmartDevice sender, String event) {
        for (SmartDevice device : devices) {
            if (device != sender) {
                device.handleEvent(event);
            }
        }
    }
}