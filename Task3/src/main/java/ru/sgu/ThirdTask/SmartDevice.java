package main.java.ru.sgu.ThirdTask;

abstract class SmartDevice {
    protected Mediator mediator;

    public SmartDevice(Mediator mediator) {
        this.mediator = mediator;
    }

    public void notify(String event) {
        mediator.notify(this, event);
    }

    public abstract void handleEvent(String event);
}