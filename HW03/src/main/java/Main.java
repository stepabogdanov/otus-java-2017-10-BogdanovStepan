import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        String[] arr = new String[0];

        System.out.println("size: " + list.size());
        list.add("1");
        list.add("5");
        list.add("7");
        list.add("6");
        list.add("6");
        list.add("6");
        list.add("6");
        list.add("6");
        list.add("6");
        list.add("6");
        list.add("6");
        list.add("6");
        list.add("6");
        list.add("3");
        list.add("8");
        list.add("8");

        System.out.println("size: " + list.size());
        System.out.println("isEmpty: " +list.isEmpty());
        System.out.println("toArray: " + Arrays.toString(list.toArray()));
        System.out.println("enlarge: "+ list.enlargeArrayToTen()+ " size after: " + list.size());
        System.out.println("size: " + list.size());
        System.out.println("toArray: " + Arrays.toString(list.toArray()));
        System.out.println("contains 3 ?: " + list.contains("3"));



    }
}
