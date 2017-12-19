package newJson;

import myJson.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewJsonMain {
    public static void main(String[] args) {
        List<String> set = new ArrayList<>(Arrays.asList("jumping", "kicking"));

        MyJson myJson = new MyJson();
        OnePerson onePerson = new OnePerson();
        Person person = new Person("Tesla", set);

        System.out.println(myJson.toJson(onePerson));
        //System.out.println(myJson.toJson(person));

    }
}
