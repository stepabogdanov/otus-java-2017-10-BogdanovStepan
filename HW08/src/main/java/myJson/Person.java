package myJson;


import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Person {
     private String firstName = "Bruce";
     private String secondName = "Lee";
     private int age = 32;
     private Car  car;
     private Set<String> setOfAbility;

     String[] nickname = new String[]{"Dragon", "Fist"};

     Person (String nameOfCar, Set<String> setOfAbility) {
         this.setOfAbility = setOfAbility;
         car =  new Car (nameOfCar);

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
