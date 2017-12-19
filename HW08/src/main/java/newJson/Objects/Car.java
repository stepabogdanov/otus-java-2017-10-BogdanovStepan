package newJson.Objects;

public class Car {
    private String brand;
    private String model;
    private MyYear manufactureYear;

    public Car(String brand) {
        this.brand = brand;
        model = "modelS";
        manufactureYear = new MyYear();
    }

    public String getBrand() {
        return brand;
    }

}
