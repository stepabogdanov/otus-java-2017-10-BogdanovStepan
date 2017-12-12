package myJson;

import java.time.Year;
import java.util.Arrays;
import java.util.Date;

public class Car {
    String brand;
    String model;
    Year manufactureYear;

    Car (String brand) {
        this.brand = brand;
        model = "modelS";
        manufactureYear = Year.now();
}

//    @Override
//    public String toString() {
//        return brand;
//    }
}
