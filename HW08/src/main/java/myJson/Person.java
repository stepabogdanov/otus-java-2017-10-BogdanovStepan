package myJson;


import java.util.Arrays;

public class Person {
     private String firstName = "Bruce";
     String secondName = "Lee";
     int age = 35;
     Car  car = new Car ("Tesla");
     String[] nickname = new String[]{"Dragon", "Fist"};

    public void print() {
        System.out.println(this);
    }



//    @Override
//    public String toString() {
//
//
//        return firstName + secondName + age + car;
//    }
}
