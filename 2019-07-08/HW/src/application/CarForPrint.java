package application;

import dto.Car;

public class CarForPrint {

    private String model;
    private double engine;
    private int year;
    private boolean ac;

    public CarForPrint(Car car) {
        model = car.getModel();
        engine = car.getEngine();
        year = car.getYear();
        ac = car.isAc();
    }

    @Override
    public String toString() {
        return model + ", " + engine + ", " + year + ", " + ac + "";
    }
}
