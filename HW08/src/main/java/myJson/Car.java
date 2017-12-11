package myJson;

import java.time.Year;
import java.util.Arrays;
import java.util.Date;

public class Car {
    private String brand = "2";
    private String model  = "modelS";
    private Year manufactureYear;
Car (String ... strings) {
    brand.concat(Arrays.toString(strings));
}

    @Override
    public String toString() {
        return brand;
    }
}
