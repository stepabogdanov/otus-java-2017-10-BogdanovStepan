package myJson;

import java.time.Year;
import java.util.Arrays;
import java.util.Date;

public class Car {
    private String brand;
    private String model;
    private MyYear manufactureYear;

    Car(String brand) {
        this.brand = brand;
        model = "modelS";
        manufactureYear = new MyYear();
    }

    public String getBrand() {
        return brand;
    }

}
