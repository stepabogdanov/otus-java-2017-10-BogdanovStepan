package myJson;

import com.google.gson.Gson;
import newJson.MyJson;
import newJson.OnePerson;

import java.util.*;

public class MainSerialize {
    public static void main(String[] args) throws IllegalAccessException {
        List<String> set = new ArrayList<>(Arrays.asList("jumping", "kicking"));

        MySerialization mySerialization = new MySerialization();
        MyJson myJson = new MyJson();
        Gson gson = new Gson();


        Person person = new Person("Tesla", set);
        Person personToCompare;
        OnePerson onePerson = new OnePerson();



        personToCompare = gson.fromJson(mySerialization.toJson(person).toString(), Person.class);

        System.out.println(gson.toJson(person));
        System.out.println(gson.toJson(personToCompare));

        System.out.println(person.equals(personToCompare));

        System.out.println(myJson.toJson(onePerson));



    }
}
