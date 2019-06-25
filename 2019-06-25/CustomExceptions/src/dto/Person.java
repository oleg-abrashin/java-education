package dto;

import exceptions.dto.WrongDataException;

public class Person {
    private String name;
    private int age;
    private double height;
    private boolean married;


    public Person(String name, int age, double height, boolean married) throws WrongDataException {
        setName(name);
        setAge(age);
        setHeight(height);
        setMarried(married);
    }

    public String getName() throws WrongDataException {
        if (name == null) throw new WrongDataException("***Error in getName function*** name is NULL pls check it: ");
        if (name.length() < 3) throw new WrongDataException("***Error in getName function*** name less 3 symbols pls check it: "+name);
        return name;
    }

    public void setName(String name) throws WrongDataException {
        if (name == null) throw new WrongDataException("***Error in setName function*** name is NULL pls check it: ");
        if (name.length() < 3) throw new WrongDataException("***Error in setName function*** name less 3 symbols pls check it: "+name);
        this.name = name;
    }

    public int getAge() throws WrongDataException{
        if (age < 0) throw new WrongDataException("***Error in getAge function*** age negative pls check it: "+age);
        return age;
    }

    public void setAge(int age) throws WrongDataException {
        if (age < 0) throw new WrongDataException("***Error in setAge function*** age negative pls check it: "+age);
        this.age = age;
    }

    public double getHeight() throws WrongDataException {
        if (height < 0) throw new WrongDataException("***Error in getHeight function*** height is negative pls check it: "+height);
        return height;
    }

    public void setHeight(double height) throws WrongDataException {
        if (height < 0) throw new WrongDataException("***Error in setHeight function*** height is negative pls check it: "+height);
        this.height = height;
    }

    public boolean isMarried() {
       return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", married=" + married +
                '}';
    }
}
