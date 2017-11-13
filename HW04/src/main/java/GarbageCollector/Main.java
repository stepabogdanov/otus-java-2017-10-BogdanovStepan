package GarbageCollector;

/* starting parameters



-XX:+UseSerialGC
-XX:+UseParNewGC
-XX:+UseG1GC
-XX:+UseConcMarkSweepGC
-XX:+UseParallelGC
-Xms512m
-Xmx512m
*/

public class Main {
    public static void main(String[] args)  {
        long timeAll = System.currentTimeMillis();
        int count = 0;
        int size = 3_000_000;

        while (count < 162) {

            Object[] array = new Object[size];
            System.out.println("Array of size: " + array.length + " created");

            for (int i = 0; i < size; i++) {
                array[i] = new String("hello" + (Math.cos(54)));
            }
            System.out.println("Created " + size + " objects.");
            count++;
            LogGc.logGC();
            System.out.println(count);

            if (count > 160) {
                size *= 20000;
            }
        }
    }


}


