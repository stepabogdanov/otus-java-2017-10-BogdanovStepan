package hw02size;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * VM options -Xmx512m -Xms512m
 * <p>
 * Runtime runtime = Runtime.getRuntime();
 * long mem = runtime.totalMemory() - runtime.freeMemory();
 * <p>
 * System.gc()
 * <p>
 * jconsole, connect to pid
 */
@SuppressWarnings({"RedundantStringConstructorCall", "InfiniteLoopStatement"})
public class MainOld{

    public static void main(String... args) throws InterruptedException {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());
        Runtime runtime = Runtime.getRuntime();
        long mem1 = 0 , mem2 = 0;


        int size = 20_000_000;
        boolean loop = true;
        System.out.println("Starting the loop");
        //runtime.freeMemory();
        //memTotalBefore = runtime.totalMemory();
        //System.out.println("Amount of memory total memory before: " + memTotalBefore );
        //memFreeBefore = runtime.freeMemory();
        //System.out.println("Amount of memory free memory before: " + memFreeBefore );
        System.gc();
        mem1 = runtime.totalMemory() - runtime.freeMemory();

        while (loop) {
            Object[] array = new Object[size];
            System.out.println("New array of size: " + array.length + " created");
            for (int i = 0; i < size; i++) {
                array[i] = new Object();
                //array[i] = new String(""); //String pool
                //array[i] = new String(new char[0]); //without String pool
                //array[i] = new MyClass();
                //array[i] = new Integer(1);
                //array[i] = 128;
                //j = 1;
                //memFreeAfter = runtime.totalMemory();
            }
            loop = false;


        }
        System.gc();
        mem2 = runtime.totalMemory() - runtime.freeMemory();

        //System.gc();
        Thread.sleep(1000); //wait for 1 sec
        System.out.println("Created " + size + " objects.");
        //memTotalAfter = runtime.totalMemory();
        //System.out.println("Amount of total memory after: " + memTotalAfter );
        //memFreeAfter = runtime.freeMemory();
        //    System.out.println("Amount of free memory after: " + memFreeAfter );
        //    System.out.println("used memory: " + (memFreeBefore - memFreeAfter));
            System.out.println("one object = " + ((mem2- mem1)/size));



        }


    private static class MyClass {
       private int i;
       private long l;
       String s;
       boolean b;


       MyClass() {
        this.i = 1;
        this.l = 1L;
        this.s = "s";
        this.b = true;


        }



        //private int i = 0;
        //private long l = 1;
    }
}


