package main.java.ru.sgu.ThirdTask;

class DoorLock extends SmartDevice {
    private boolean isClosed;
    public DoorLock(Mediator mediator) {
        super(mediator);
        this.isClosed = false;

    }

    public void open() {
        isClosed = false;
        System.out.println("Дверной замок открыт");
        mediator.notify(this, "Дверной замок открыт");
    }

    public void close() {
        isClosed = true;
        System.out.println("Дверной замок закрыт");
        mediator.notify(this, "Дверной замок закрыт");
    }

    @Override
    public void handleEvent(String event) {
        System.out.println("Дверной замок получил уведомление: " + event);
        mediator.notify(this, event);
    }
}