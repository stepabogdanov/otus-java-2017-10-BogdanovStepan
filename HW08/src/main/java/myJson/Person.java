package myJson;


import java.util.Arrays;

public class Person {
     private String firstName = "Bruce";
     String secondName = "Lee";
     int age = 32;
     Car  car;
     String[] nickname = new String[]{"Dragon", "Fist"};

     Person (String nameOfcar) {
         car =  new Car (nameOfcar);

     }




@Override
    public boolean equals (Object o ) {
        if (this ==o) return true;
         Person that = (Person)o;
        if (!that.firstName.equals(firstName)) return false;
        if (!that.secondName.equals(secondName)) return false;
        if (that.age != age) return false;
        if (!that.car.getBrand().equals(car.getBrand())) return false;
//        if (that.nickname != nickname) return false;

        return true;
}
}
