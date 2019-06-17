package application;

import model.Person;

public class ImmutablePersonApp {

    public static void main(String[] args) {

        Person p = new Person ("Sasha", 62);

        String sasha = "Sasha";
        String masha = sasha.substring(2);
        System.out.println(sasha);
        System.out.println(masha);
    }

}
