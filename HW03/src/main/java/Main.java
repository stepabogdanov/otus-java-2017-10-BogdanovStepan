import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        List<String> listFull = new ArrayList();
        listFull.add("80");
        listFull.add("82");
        listFull.add("83");
        listFull.add("83");
        listFull.add("83");
        listFull.add("83");
        listFull.add("83");
        listFull.add("83");
        listFull.add("83");



        String[] arr = new String[0];

        System.out.println("size: " + list.size());
        System.out.println("isEmpty: " +list.isEmpty());
        list.add("1");
        list.add("5");
        list.add("7");
        list.add("7");
        list.add("7");
        list.add("7");



        System.out.println("size: " + list.size());
        System.out.println("isEmpty: " +list.isEmpty());
        System.out.println("toArray: " + Arrays.toString(list.toArray()));
        //System.out.println("enlarge: "+ list.enlargeArrayToTen()+ " size after: " + list.size());
        System.out.println("size: " + list.size());
        System.out.println("toArray: " + Arrays.toString(list.toArray()));
        System.out.println("contains 3 ?: " + list.contains("3"));
        System.out.println("remove 3: " +list.remove("3"));
        list.add("12");


        list.addAll(listFull,5);
        System.out.println("toArray: " + Arrays.toString(list.toArray()));


    }
}
