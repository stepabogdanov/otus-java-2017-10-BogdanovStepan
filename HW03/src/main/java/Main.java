import java.util.*;

public  class Main {
    public static void main(String[] args) {


        MyArrayList<String> list = new MyArrayList<>();
        List<String> listFull = new ArrayList();
        List<String> listToCopy = new ArrayList(40);
        listFull.add("80");
        listFull.add("82");


        listToCopy.add("100");
        listToCopy.add("101");
        listToCopy.add("102");


        String[] arr = new String[0];

        System.out.println("size: " + list.size());
        System.out.println("isEmpty: " + list.isEmpty());
        list.add("1");
        list.add("5");
        list.add("7");


        System.out.println("size: " + list.size());
        System.out.println("isEmpty: " + list.isEmpty());
        System.out.println("toArray: " + Arrays.toString(list.toArray()));
        //System.out.println("enlarge: "+ list.enlargeArrayToTen()+ " size after: " + list.size());
        System.out.println("size: " + list.size());
        System.out.println("toArray: " + Arrays.toString(list.toArray()));
        System.out.println("contains 3 ?: " + list.contains("3"));
        System.out.println("remove 3: " + list.remove("7"));
        list.add("12");


        list.addAll(listFull, 5);
        System.out.println("toArray: " + Arrays.toString(list.toArray()));

        Collections.copy(listToCopy, listFull);
        System.out.println("toArray_listToCopy: " + Arrays.toString(listToCopy.toArray()));

        Collections.copy(list, listToCopy);
        System.out.println("toArray: " + Arrays.toString(listToCopy.toArray()));
        list.add("50");
        list.add("58");
        list.add("56");
        Collections.sort(list);
        System.out.println("toArray: " + Arrays.toString(list.toArray()));






    }
}

//        System.out.println(list.get(8));
//        list.set(8, "20");
//        System.out.println(list.get(8));
