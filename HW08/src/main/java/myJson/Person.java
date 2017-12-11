package myJson;


import java.util.Arrays;

public class Person {
     String firstName = "Bruce";
     String secondName = "Lee";
     int age = 35;
     Car  cars = new Car ("opel", "audi");

    public void print() {
        System.out.println(this);
    }



    @Override
    public String toString() {


        return firstName + secondName + age + cars;
    }
}
