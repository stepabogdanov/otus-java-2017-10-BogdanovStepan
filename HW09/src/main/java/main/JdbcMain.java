package main;

import base.DBService;
import base.UserDataSet;
import connnection.DBServiceUpdate;

import java.util.List;

public class JdbcMain {

    public static void main(String[] args) throws Exception {
        new JdbcMain().run();

    }

    private void run() throws Exception {

        UserDataSet user1 = new UserDataSet("Ivan", 35);
        UserDataSet user2 = new UserDataSet("Alex", 34);
        try (DBService dbService = new DBServiceUpdate())

        {
            System.out.println(dbService.getMetaData());
            //dbService.prepareTables();
            //dbService.addNames("Stepan", "Alex");
            //dbService.saveUser(user1);
            //dbService.saveUser(user2);
            //dbService.getUserName(3);
            List<String> names = dbService.getAllNames();
            System.out.println(names);
            dbService.loadUser2(2, UserDataSet.class);
            //dbService.dropTable();

        }


    }
}
