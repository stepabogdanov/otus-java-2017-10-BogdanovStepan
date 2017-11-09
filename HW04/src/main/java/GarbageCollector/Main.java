package GarbageCollector;

import java.lang.management.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        long time = 0 ;
        long count = 0 ;
        String objectName = "";
        int cnt = 0;

        while (cnt < 9) {
            int local = 10_000_000;
            Object[] array = new Object[local];
            System.out.println("Array of size: " + array.length + " created");

            for (int i = 0; i < local; i++) {
                array[i] = new String(new char[0]);
            }
            System.out.println("Created " + local + " objects.");

            cnt++;
        }

        List<GarbageCollectorMXBean> mxBean = ManagementFactory.getGarbageCollectorMXBeans();
        Iterator iterator  = mxBean.iterator();
        for (GarbageCollectorMXBean gc : mxBean) {
                time = gc.getCollectionTime();
                System.out.println(Arrays.toString(gc.getMemoryPoolNames()));
                count = gc.getCollectionCount();
                objectName = gc.getObjectName().toString();
            System.out.println("time: " + time);
            System.out.println("count: " + count);
            System.out.println("objrct Name: " + objectName);
        }


    }
}

