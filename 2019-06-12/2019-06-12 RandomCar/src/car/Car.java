package car;

import randomlib.RandomLib;

public class Car {
	
	private static final String[] CAR_MODELS =  {
			"Pobeda", "Volga", "Moskvich","Zhiguli","Zaporozhets",
			"Ford","Toyota","Kia","Wolkswagen","Fiat"};
	private static final int MIN_YEAR = 1980;
	private static final int MAX_YEAR = 2019;
	private static final double MIN_ENGINE = 1.3;
	private static final double MAX_ENGINE = 2.3;
	private static final int MIN_AC_YEAR = 2000;
	private static final double AC_PROBABILITTY = 0.3;
	
	private String model;
	private int year;
	private double engine;
	private boolean ac;
	
	public Car() {
		super();
	}
	public Car(String model, int year, double engine, boolean ac) {
		super();
		this.model = model;
		this.year = year;
		this.engine = engine;
		this.ac = ac;
	}
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
	@Override
	public String toString() {
		return "Car [" + model + ", " 
	                   + year + ", " 
				       + String.format("%.1f", engine) + ", " 
	                   + (ac ? "yes" : "no") + "]";
	}
	
	public static Car randomCar() {
		
		String randomModel = RandomLib.nextStringFromSet(CAR_MODELS);
		int randomYear = RandomLib.nextIntRange(MIN_YEAR, MAX_YEAR);
		double randomEngine = RandomLib.nextDoubleRange(MIN_ENGINE, MAX_ENGINE);
		boolean randomAC = randomYear < MIN_AC_YEAR ?
				           false : RandomLib.nextRandomBoolean(AC_PROBABILITTY);
	
		return new Car(randomModel, randomYear, randomEngine, randomAC);
	}
	
	

}
