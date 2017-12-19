package newJson;

import com.google.gson.Gson;
import newJson.Objects.Person;
import newJson.MyJson.MyJson;
import newJson.Objects.OnePerson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewJsonMain {
    public static void main(String[] args) {
        List<String> set = new ArrayList<>(Arrays.asList("jumping", "kicking"));


        MyJson myJson = new MyJson();
        Gson gson = new Gson();


        Person person = new Person("Tesla", set);
        Person personToCompare;
        OnePerson onePerson = new OnePerson();



        personToCompare = gson.fromJson(myJson.toJson(person).toString(), Person.class);

        System.out.println(gson.toJson(person));
        System.out.println(myJson.toJson(personToCompare));

        System.out.println(person.equals(personToCompare));


    }
}
