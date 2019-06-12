package car;

import randomlib.RandomLib;

public class Car {

    private static final String[] CAR_MODELS = {"Duster","Logan","Sandero","Kaptur","Master","Dokker" };
    private static final int MIN_YEAR = 1980;
    private static final int MAX_YEAR = 2019;
    private static final double MIN_ENGINE = 1.3;
    private static final double MAX_ENGINE = 2.3;
    private static final int MIN_AC_YEAR = 2000;
    private static final double AC_PROBABILITY = 0.3;


    private String model;
    private int year;
    private double engine;
    private boolean ac;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public boolean isAc() {
        return ac;
    }

    public void setAc(boolean ac) {
        this.ac = ac;
    }

    public Car(){
        super();
    }

    public Car(String model, int year, double engine, boolean ac) {
        this.model = model;
        this.year = year;
        this.engine = engine;
        this.ac = ac;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", engine=" + String.format("%.1f",engine) +
                ", ac=" + (ac ? "yes" : "no") +
                '}';
    }

    public static Car randomCar() {

        String randomModel = RandomLib.nextStringFromSet(CAR_MODELS);

        int randomYear = RandomLib.nextIntRange(MIN_YEAR, MAX_YEAR);

        double randomEngine = RandomLib.nextDoubleRange(MIN_ENGINE,MAX_ENGINE);

        boolean randomAC = randomYear < MIN_AC_YEAR ?

                false: RandomLib.nextRandomBoolean(AC_PROBABILITY);

        return new Car(randomModel, randomYear, randomEngine, randomAC);

    }


}
