package model;

public class Kolkhoz {

    private int zakroma = 0;

    public void harvest() {
        zakroma = zakroma + 1000000;
    }

    public int getZakroma() {
        return zakroma;
    }

}
