import java.util.*;

public class Main {

    public static void main(String[] args) {

        int size = 10;
        MyArrayList<Integer> list = new MyArrayList<>();
        List<Integer> listToCopy = new ArrayList<>();

        listToCopy.add(13);
        listToCopy.add(33);
        listToCopy.add(77);
        for (int i = 0; i < size ; i++) {
            list.add(i);
        }

        list.addAll(listToCopy);

        System.out.println("toArray addAll: \n" + Arrays.toString(list.toArray()));
        Collections.shuffle(list);
        System.out.println("toArray: shuffle: \n" + Arrays.toString(list.toArray()));
        listToCopy.add(11);
        listToCopy.add(9);

        Collections.copy(list, listToCopy);
        System.out.println("toArray: copy: \n" + Arrays.toString(list.toArray()));

        Collections.sort(list);
        System.out.println("toArray: sort: \n" + Arrays.toString(list.toArray()));
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("toArray: sort reverse: \n" + Arrays.toString(list.toArray()));
    }
}
