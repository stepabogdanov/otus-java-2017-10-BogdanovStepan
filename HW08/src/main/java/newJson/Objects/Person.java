package newJson.Objects;

import java.util.Arrays;
import java.util.List;

public class Person {
     private String firstName = "Bruce";
     private String secondName = "Lee";
     private int age = 32;
     private Car  car;
     private List<String> setOfAbility;

     private String[] nickname = new String[]{"Dragon", "Fist"};

     public Person(String nameOfCar, List<String> setOfAbility) {
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
        if (!Arrays.equals(that.nickname, nickname)) return false;
        if (!that.setOfAbility.equals(setOfAbility)) return false;

        return true;
    }
}
