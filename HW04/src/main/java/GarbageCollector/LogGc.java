package GarbageCollector;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.util.Arrays;


public class LogGc {
    static void  logGC() {
        String nameGC;
        String collectionsGC;
        String timeGC;
        String fileSuffix = "";
        long upTime;
        Map<String, String> mapOfSuffix;

        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        upTime = runtimeMXBean.getUptime();
        List<String> jvmArgs = runtimeMXBean.getInputArguments();
        List<String> vmOptions = new ArrayList<>();
        for (String listArgs: jvmArgs){
            if (listArgs.startsWith("-X")) {
                vmOptions.add(listArgs);
            }
        }
        List<GarbageCollectorMXBean> mxBean = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gc: mxBean) {
            mapOfSuffix = gc.getObjectName().getKeyPropertyList();
            fileSuffix = fileSuffix.concat("_" + mapOfSuffix.get("name"));
        }

        List<String> listOfGcName = new ArrayList<>();
        List<Long> listOfGcTime = new ArrayList<>();
        List<Long> listOfGcCount = new ArrayList<>();

        File file = new File("stat_" + fileSuffix );

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for(
                GarbageCollectorMXBean gc :mxBean) {
                    nameGC = gc.getObjectName().getKeyPropertyListString();
                    collectionsGC = String.valueOf(gc.getCollectionCount());
                    timeGC = String.valueOf(gc.getCollectionTime());

                    bw.write(nameGC + " " + "COLLECTIONS: " + collectionsGC + " TIME: " + timeGC);
                    bw.append('\n');
                    bw.flush();
                }
            Iterator iteratorName = listOfGcName.iterator();
            Iterator iteratorTime = listOfGcTime.iterator();
            Iterator iteratorCollections = listOfGcName.iterator();

            while(iteratorName.hasNext()) {
                bw.write(iteratorName.next().toString());
                bw.write(iteratorTime.next().toString());
                bw.write(iteratorCollections.next().toString());
                bw.append('\n');
                bw.flush();
            }
            bw.write(Arrays.toString(vmOptions.toArray()));
            //fw.write("Tatal time collections lasts: " + String.valueOf(System.currentTimeMillis()-amountTime));
            bw.write("\nUp time: " + String.valueOf(upTime));
            bw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
