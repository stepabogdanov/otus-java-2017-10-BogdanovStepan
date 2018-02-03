package main;

import cashEngine.CashElement;
import cashEngine.CashEngine;
import cashEngine.CashEngineImpl;
import connnection.DBService;
import base.UserDataSet;
import connnection.DBServiceNew;

import java.util.List;
import java.util.Map;


// mysql> SET GLOBAL time_zone = '+3:00';
public class JdbcMain {

    public static void main(String[] args) throws Exception {
        new JdbcMain().run();

    }

    private void run() throws Exception {

        UserDataSet user1 = new UserDataSet("Ivan", 35);
        UserDataSet user2 = new UserDataSet("Alex", 34);
        UserDataSet user3 = new UserDataSet("Olga", 22);
        UserDataSet user4 = new UserDataSet("Mikel", 29);
        UserDataSet user5 = new UserDataSet("Pavel", 40);
        try (DBService dbService = new DBServiceNew())

        {
            System.out.println(dbService.getMetaData());
            dbService.dropTable();
            dbService.prepareTables();
//            dbService.addNames("Stepan", "Alex");
            CashEngine<Long, Map> cashEngine = new CashEngineImpl<>(3, 30, 30, true);
            cashEngine.put(dbService.saveUserWithCash(user1));
            cashEngine.put(dbService.saveUserWithCash(user2));
            cashEngine.put(dbService.saveUserWithCash(user3));
            cashEngine.put(dbService.saveUserWithCash(user4));
            cashEngine.put(dbService.saveUserWithCash(user5));
            cashEngine.put(dbService.saveUserWithCash(user1));

            CashElement cashElement = cashEngine.get(4l);
            CashElement cashElement4 = cashEngine.get(1l);

            System.out.println("hit: " + cashEngine.getHitCount());
            System.out.println("mis: " + cashEngine.getMissCount());

            //System.out.println(dbService.getUserName(3));
//            List<String> names = dbService.getAllNames();

//            System.out.println(names);


//            System.out.println(dbService.loadUser2(2, UserDataSet.class));
//            System.out.println(dbService.loadUser2(5, UserDataSet.class));
//            System.out.println(dbService.loadUser2(3, UserDataSet.class));
//            System.out.println(dbService.loadUser2(99, UserDataSet.class));

        }


    }
}
