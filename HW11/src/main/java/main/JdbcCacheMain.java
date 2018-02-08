package main;

import base.UserDataSet;
import base.DBService;
import connnection.DBServiceCache;


// mysql> SET GLOBAL time_zone = '+3:00';
public class JdbcCacheMain {

    public static void main(String[] args) throws Exception {
        new JdbcCacheMain().run();

    }

    private void run() throws Exception {

        UserDataSet user1 = new UserDataSet("Ivan", 35);
        UserDataSet user2 = new UserDataSet("Alex", 34);
        UserDataSet user3 = new UserDataSet("Olga", 22);
        UserDataSet user4 = new UserDataSet("Mikel", 29);
        UserDataSet user5 = new UserDataSet("Pavel", 40);
        try (DBService dbService = new DBServiceCache())

        {
            System.out.println(dbService.getMetaData());
            dbService.dropTable();
            dbService.prepareTables();
            dbService.addNames("Stepan", "Alex");


            dbService.saveUser(user1);
            dbService.saveUser(user2);
            dbService.saveUser(user3);
            dbService.saveUser(user4);
            dbService.saveUser(user5);


            System.out.println(dbService.loadUser2(4, UserDataSet.class));
            System.out.println(dbService.loadUser2(5, UserDataSet.class));
            Thread.sleep(1000);
            System.out.println(dbService.loadUser2(1, UserDataSet.class));
            System.out.println(dbService.loadUser2(2, UserDataSet.class));
            System.out.println(dbService.loadUser2(3, UserDataSet.class));

            System.out.println("miss: " + dbService.getCache().getMissCount());
            System.out.println("hit: " + dbService.getCache().getHitCount());
            System.out.println(dbService.getCache());



            System.out.println(dbService.getUserName(4));
//            List<String> names = dbService.getAllNames();

//            System.out.println(names);


//            System.out.println(dbService.loadUser2(2, UserDataSet.class));
//            System.out.println(dbService.loadUser2(5, UserDataSet.class));
//            System.out.println(dbService.loadUser2(3, UserDataSet.class));
//            System.out.println(dbService.loadUser2(99, UserDataSet.class));

        }


    }
}
