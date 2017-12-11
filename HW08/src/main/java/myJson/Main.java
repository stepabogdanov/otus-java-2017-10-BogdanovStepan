package myJson;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
      Person person = new Person();
      person.print();
        MySerialization.reflection(person);
    }
}
