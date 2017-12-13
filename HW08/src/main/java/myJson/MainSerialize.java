package myJson;

import com.google.gson.Gson;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainSerialize {
    public static void main(String[] args) throws IllegalAccessException {
        Set<String> set = new HashSet<>(Arrays.asList("jumping", "kicking"));

        Person person = new Person("Tesla", set);
        Person personToCompare;

        Gson gson = new Gson();

        personToCompare = gson.fromJson(MySerialization.reflection(person).toString(), Person.class);

        System.out.println(gson.toJson(person));
        System.out.println(gson.toJson(personToCompare));

        System.out.println(person.equals(personToCompare));


    }
}
