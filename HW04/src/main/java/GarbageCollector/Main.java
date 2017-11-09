package GarbageCollector;

import java.io.*;
import java.lang.management.*;
import java.util.*;


// -XX:+UseSerialGC
// -Xms52m
// -Xmx52m

public class Main {
    public static void main(String[] args) throws IOException {
        long timeAll = System.currentTimeMillis();
        int count = 0;
        int size = 5_000_000;

        while (count < 2) {

            Object[] array = new Object[size];
            System.out.println("Array of size: " + array.length + " created");

            for (int i = 0; i < size; i++) {
                array[i] = new String("hello" + (Math.cos(54)));
            }
            System.out.println("Created " + size + " objects.");
            count++;
            logGC();
            System.out.println(count);

            if (count > 80) {
                size *= 2000;
            }

//        timeAll = System.currentTimeMillis() - timeAll;
//        System.out.println(timeAll);

        }
    }
    static void  logGC() throws IOException {
        String nameGC = "";
        String collectinsGC = "";
        String timeGC = "";

        File file = new File("stat.txt");

        List<GarbageCollectorMXBean> mxBean = ManagementFactory.getGarbageCollectorMXBeans();
        List<String> listOfGcName = new ArrayList<>();
        List<Long> listOfGcTime = new ArrayList<>();
        List<Long> listOfGcCount = new ArrayList<>();
        FileWriter fw = new FileWriter(file);

        for (GarbageCollectorMXBean gc : mxBean) {

            listOfGcTime.add(gc.getCollectionTime());
                for (Long time  : listOfGcTime) {

                    fw.write("time: ");
                    fw.write(String.valueOf(time));
                    fw.append('\n');
                    fw.flush();
                }
            listOfGcName.add(gc.getObjectName().toString());
                for (String name  : listOfGcName) {
                    fw.write("name: ");
                    fw.write(name);
                    fw.append('\n');
                    fw.flush();
                }
            listOfGcCount.add(gc.getCollectionCount());
                for (Long count  : listOfGcCount) {
                    fw.write("count: ");
                    fw.write(String.valueOf(count));
                    fw.append('\n');
                    fw.flush();
                }


//            System.out.println(Arrays.toString(listOfGcCount.toArray()));
//            System.out.println(Arrays.toString(listOfGcName.toArray()));
//            System.out.println(Arrays.toString(listOfGcTime.toArray()));
            //count = gc.getCollectionCount();
            //objectName = gc.getObjectName().toString();
        }


        Iterator iteratorName = listOfGcName.iterator();
        Iterator iteratorTime = listOfGcName.iterator();
        Iterator iteratorCollections = listOfGcName.iterator();
        while (iteratorName.hasNext()){
            fw.write(iteratorName.next().toString());
            fw.write(iteratorTime.next().toString());
            fw.write(iteratorCollections.next().toString());
            fw.flush();
            fw.append('\n');
        }
//        fw.append('\n');
//        System.out.println("time: " + time);
//        fw.write("time: ");
//        fw.write(String.valueOf(time));
//        fw.flush();
//
//        fw.append('\n');
//        System.out.println("count: " + count);
//        fw.write("count: ");
//        fw.write(String.valueOf(count));
//        fw.flush();

        //objectName = listOfGcName.toArray();
        //fw.append('\n');
        //System.out.println("object Name: " + objectName);
        //fw.write(Arrays.toString(objectName));
        //fw.flush();
    }

}


