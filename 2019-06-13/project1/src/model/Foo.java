package model;

public class Foo {

    public static String NAME = "Vasia";

    static {
        System.out.println(NAME);
        NAME = "Masha";
        System.out.println(NAME);
    }



    public Foo(){
        NAME = "Pasha";
        System.out.println(NAME);
    }

}
