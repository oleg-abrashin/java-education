package application;

import model.Kolkhoz;

public class ArgicultureApp {

	public static void main(String[] args) {
		Kolkhoz[] village = new Kolkhoz[3];
		
		for (int i = 0; i < village.length; i++) {
			village[i] = new Kolkhoz();
		}
		
		for (int i = 0; i < village.length; i++) {
			village[i].harvest();
		}
		
		for (int i = 0; i < village.length; i++) {
			System.out.println(village[i].getZakroma());
		}

	}

}
