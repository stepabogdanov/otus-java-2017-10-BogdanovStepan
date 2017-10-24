package hw02size;

public class Main3 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        String string = new String("abc");
        Class clazz = string.getClass();
        Object[] objects = new Object[3];
        String eString = new String();
        eString = string.getClass().newInstance();
        eString = string;
        objects[0] = string;
        objects[1] = eString;
        System.out.println("object 0: " + objects[0]);
        System.out.println("object 1: " + objects[1]);

    }
}
