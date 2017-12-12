package myJson;


import java.util.Arrays;

public class Person {
     String firstName = "Bruce";
     String secondName = "Lee";
     int age = 35;
     String[]  cars = new String[] {"opel", "audi"};

    public void print() {
        System.out.println(this);
    }



    @Override
    public String toString() {


        return firstName + secondName + age + cars;
    }
}
