package application;

import model.Finance;

public class CreditorsAndDebtorsApp {

	public static void main(String[] args) {
		
		Finance finance = new Finance();
		finance.fill(300);
		//finance.display();
		//System.out.println(finance.getSize());
		finance.findSuperCreditor();
	}

}
