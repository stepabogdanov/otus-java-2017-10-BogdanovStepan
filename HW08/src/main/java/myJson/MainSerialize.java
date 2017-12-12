package myJson;

import com.google.gson.Gson;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class MainSerialize {
    public static void main(String[] args) throws IllegalAccessException {

        Person person = new Person("Tesla");
        Person personToCompare;

        Gson gson = new Gson();

        personToCompare = gson.fromJson(MySerialization.reflection(person).toString(), Person.class);

        System.out.println(gson.toJson(person));
        System.out.println(gson.toJson(personToCompare));

        System.out.println(person.equals(personToCompare));


    }
}
