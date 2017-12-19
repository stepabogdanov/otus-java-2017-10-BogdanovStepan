package newJson;

import myJson.Car;

import javax.json.Json;
import javax.json.JsonObject;

public class OnePerson {

    String name = "Bruce";
    int age = 35;
    Integer birthDay = 1982;
    String [] friends = new String[] {"Arnold", "Helga"};
    int[] ageOfChildren = new int[] {6, 10};
    Car car = new Car("Tesla");
}
