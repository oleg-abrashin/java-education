package application;

public class User implements ICarDriver, IPrintDriver{

	@Override
	public void drive() {
		IPrintDriver.super.drive();
		ICarDriver.super.drive();
	}
}
