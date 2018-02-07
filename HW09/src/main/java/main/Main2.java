package main;

import java.awt.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        long lifeTimeMS = 5000;
        long creationTime = 0;
        Toolkit toolkit = Toolkit.getDefaultToolkit();



        Map<Integer,Long> map = new HashMap<>();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println(map);

            }
        };
        for (int i=0; i< 10; i++) {
            map.put( (i), System.currentTimeMillis());
            //System.out.println( i + "=" + map.get(i));
            Thread.sleep(10);
            timer.schedule(timerTask, 101,101);
            //timer.cancel();
        }


        //timer.cancel();
        System.out.println(map);

    }
}

