package newJson.Objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnePerson {

    String name = "Bruce";
    int age = 35;
    Integer birthDay = 1982;
    String [] friends = new String[] {"Arnold", "Helga"};
    int[] ageOfChildren = new int[] {6, 10};
    Car car = new Car("Tesla");
    List<String> list = new ArrayList<>(Arrays.asList("one", "two"));
}
