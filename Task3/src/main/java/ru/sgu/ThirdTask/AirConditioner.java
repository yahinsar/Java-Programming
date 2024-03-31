package main.java.ru.sgu.ThirdTask;

class AirConditioner extends SmartDevice {
    private boolean isTurnedOn;
    public AirConditioner(Mediator mediator) {
        super(mediator);
        this.isTurnedOn = false;
    }

    public void turnOn() {
        isTurnedOn = true;
        System.out.println("Кондиционер включен");
    }

    public void turnOff() {
        isTurnedOn = false;
        System.out.println("Кондиционер выключен");
    }

    @Override
    public void handleEvent(String event) {
        System.out.println("Кондиционер получил уведомление: " + event);
        if (event.equals("Дверной замок закрыт")) {
            turnOff();
        } else if (event.equals("Дверной замок открыт")) {
            turnOn();
        }
    }
}