package main;

import connnection.DBService;
import base.UserDataSet;
import connnection.DBServiceNew;

import java.util.List;

public class JdbcMain {

    public static void main(String[] args) throws Exception {
        new JdbcMain().run();

    }

    private void run() throws Exception {

        UserDataSet user1 = new UserDataSet("Ivan", 35);
        UserDataSet user2 = new UserDataSet("Alex", 34);
        UserDataSet user3 = new UserDataSet("OLga", 22);
        UserDataSet user4 = new UserDataSet("Mikel", 29);
        UserDataSet user5 = new UserDataSet("Pavel", 45);
        try (DBService dbService = new DBServiceNew())

        {
            System.out.println(dbService.getMetaData());
            dbService.dropTable();
            dbService.prepareTables();
            dbService.addNames("Stepan", "Alex");
            dbService.saveUser(user1);
            dbService.saveUser(user2);
            dbService.saveUser(user3);
            System.out.println(dbService.getUserName(3));
            List<String> names = dbService.getAllNames();

            System.out.println(dbService.loadUser2(2, UserDataSet.class));
            System.out.println(dbService.loadUser2(5, UserDataSet.class));
            System.out.println(dbService.loadUser2(3, UserDataSet.class));
            System.out.println(dbService.loadUser2(99, UserDataSet.class));

        }


    }
}
