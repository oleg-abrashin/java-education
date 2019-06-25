package application;

import dto.Person;
import exceptions.dto.WrongDataException;

public class CustomExceptionsApp {
    public static void main(String[] args) throws WrongDataException {
        Person p = new Person("Sasha", 61, 177.3,true);

        System.out.println(p);
    }
}
