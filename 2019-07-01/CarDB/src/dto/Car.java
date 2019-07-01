package dto;

import comparators.EngineCarComparator;
import comparators.ModelCarComparator;
import comparators.YearCarComparator;
import randomlib.RandomLib;

import java.util.Comparator;
import java.util.Objects;

public class Car implements Comparable<Car>{

    public static final Comparator<Car> naturalComparator =
            (new ModelCarComparator())
            .thenComparing(new YearCarComparator())
            .thenComparing(new EngineCarComparator());


    private static final String[] CAR_MODELS = {"Duster","Logan","Sandero","Kaptur","Master","Dokker" };
    private static final int MIN_YEAR = 1980;
    private static final int MAX_YEAR = 2019;
    private static final double MIN_ENGINE = 1.3;
    private static final double MAX_ENGINE = 2.3;
    private static final int MIN_AC_YEAR = 2000;
    private static final double AC_PROBABILITY = 0.3;

    private int id;
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

    public Car(int id, String model, int year, double engine, boolean ac) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.engine = engine;
        this.ac = ac;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                "model='" + model + '\'' +
                ", year=" + year +
                ", engine=" + String.format("%.1f",engine) +
                ", ac=" + (ac ? "yes" : "no") +
                '}';
    }

    public static Car randomCar() {

        int randomID = RandomLib.nextIntRange(100000000, 999999999);

        String randomModel = RandomLib.nextStringFromSet(CAR_MODELS);

        int randomYear = RandomLib.nextIntRange(MIN_YEAR, MAX_YEAR);

        double randomEngine = RandomLib.nextDoubleRange(MIN_ENGINE,MAX_ENGINE);

        boolean randomAC = randomYear < MIN_AC_YEAR ?

                false: RandomLib.nextRandomBoolean(AC_PROBABILITY);

        return new Car(randomID,randomModel, randomYear, randomEngine, randomAC);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (year != car.year) return false;
        if (Double.compare(car.engine, engine) != 0) return false;
        if (ac != car.ac) return false;
        return model != null ? model.equals(car.model) : car.model == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + year;
        temp = Double.doubleToLongBits(engine);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (ac ? 1 : 0);
        return result;
    }

    @Override
    public int compareTo(Car other) {
       return naturalComparator.compare(this,other);
    }

    public static Car[] getRandomGarageArray(int n){
        if(n < 0) n = 0;
        Car[] result = new Car[n];

        for (int i = 0; i < n; i++) {
            result[i] = randomCar();
        }

        return result;
    }
}
