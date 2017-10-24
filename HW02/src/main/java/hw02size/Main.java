package hw02size;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InterruptedException, NoSuchMethodException, InvocationTargetException {
        Object object = new Object();
        String stringPoll = new String();
        String string = new String(new char[0]);
        Integer integer = new Integer(1);
        MyClass myClass = new MyClass();
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>(100);
        Map<String, String> map = new HashMap<>();


        int[] i1 = new int[0];

        MeasureObjects.MeasureSize(object);
        MeasureObjects.MeasureSize(string);
        MeasureObjects.MeasureSize(stringPoll);
        //MeasureObjects.MeasureSize(integer);
        MeasureObjects.MeasureSize(myClass);
        MeasureObjects.MeasureSize(list);
        //MeasureObjects.MeasureSize(list2);
        MeasureObjects.MeasureSize(map);
    }
}
