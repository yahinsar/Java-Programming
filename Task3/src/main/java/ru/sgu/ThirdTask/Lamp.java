package main.java.ru.sgu.ThirdTask;

class Lamp extends SmartDevice {
    private boolean isTurnedOn;
    public Lamp(Mediator mediator) {
        super(mediator);
        this.isTurnedOn = false;
    }

    public void turnOn() {
        isTurnedOn = true;
        System.out.println("Лампа включена");
    }

    public void turnOff() {
        isTurnedOn = false;
        System.out.println("Лампа выключена");
    }

    @Override
    public void handleEvent(String event) {
        System.out.println("Лампа получила уведомление: " + event);
        if (event.equals("Дверной замок закрыт")) {
            turnOff();
        } else if (event.equals("Дверной замок открыт")) {
            turnOn();
        }
    }
}