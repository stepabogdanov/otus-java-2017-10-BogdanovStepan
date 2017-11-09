package GarbageCollector;

import java.io.*;
import java.lang.management.*;
import java.util.*;


// -XX:+UseSerialGC
//-XX:+UseParNewGC
//-XX:+UseG1GC
// -Xms512m
// -Xmx512m

public class Main {
    public static void main(String[] args) throws IOException {
        long timeAll = System.currentTimeMillis();
        int count = 0;
        int size = 3_000_000;

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
                size *= 20000;
            }

//        timeAll = System.currentTimeMillis() - timeAll;
//        System.out.println(timeAll);

        }
    }
    static void  logGC() throws IOException {
        String nameGC = "";
        String collectinsGC = "";
        String timeGC = "";

        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        List<String> jvmArgs = runtimeMXBean.getInputArguments();
        List<GarbageCollectorMXBean> mxBean = ManagementFactory.getGarbageCollectorMXBeans();

        List<String> listOfGcName = new ArrayList<>();
        List<Long> listOfGcTime = new ArrayList<>();
        List<Long> listOfGcCount = new ArrayList<>();

        File file = new File("stat_2024.txt");

        FileWriter fw = new FileWriter(file);

        for (GarbageCollectorMXBean gc : mxBean) {

            nameGC = gc.getObjectName().getKeyPropertyListString();
            collectinsGC = String.valueOf(gc.getCollectionCount());
            timeGC = String.valueOf(gc.getCollectionTime());

            fw.write(nameGC + " " + "COLLECTIONS: " + collectinsGC + " TIME: " + timeGC);
            fw.append('\n');
            fw.flush();
        }


        Iterator iteratorName = listOfGcName.iterator();
        Iterator iteratorTime = listOfGcTime.iterator();
        Iterator iteratorCollections = listOfGcName.iterator();
        while (iteratorName.hasNext()){
            fw.write(iteratorName.next().toString());
            fw.write(iteratorTime.next().toString());
            fw.write(iteratorCollections.next().toString());
            fw.flush();
            fw.append('\n');
        }
        fw.write(Arrays.toString(jvmArgs.toArray()));
        fw.flush();
    }

}


