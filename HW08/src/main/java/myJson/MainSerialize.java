package myJson;

import com.google.gson.Gson;

public class MainSerialize {
    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person();
        OnePerson onePerson = new OnePerson();
        //person.print();
        System.out.println(MySerialization.reflection(person));
        //MySerialization.reflection(onePerson);


        Gson gson = new Gson();
        System.out.println(gson.toJson(person));
        //System.out.println(gson.toJson(onePerson));
    }
}
