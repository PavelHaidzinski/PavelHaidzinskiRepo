package com.company;

/**
 * Created by Pavel_Haidzinski on 8/17/2017.
 */
public class Employee {

    String id;
    String firstName;
    String lastName;
    String location;

    @Override
    public String toString(){
        return firstName + " " + lastName + " " + "(" +id+ ")" + location;
    }

}
