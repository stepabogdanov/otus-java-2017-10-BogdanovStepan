import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList();
        list.add("1");
        list.add("2");
        list.add("4");
        list.add("5");
        list.add("8");
        list.enlargeArrayToTen();
        System.out.println(list.isEmpty());
        //System.out.println(list.contains("2"));
        System.out.println(Arrays.toString(list.toArray()));


    }
}
