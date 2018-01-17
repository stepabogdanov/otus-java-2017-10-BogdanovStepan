package main;

import base.DBService;
import base.DataSet;
import base.NewUser;
import base.UserDataSet;
import connnection.DBServiceNew;
import connnection.DBServiceUpdate;

import java.util.List;

public class JdbcMain {

    public static void main(String[] args) throws Exception {
        new JdbcMain().run();

    }

    private void run() throws Exception {

        UserDataSet user1 = new UserDataSet("Ivan", 35);
        UserDataSet user2 = new UserDataSet("Alex", 34);
        DataSet user3 = new NewUser("Alex", 34, "89058356752");
        try (DBService dbService = new DBServiceNew())

        {
            System.out.println(dbService.getMetaData());
            dbService.prepareTables();
            //dbService.addNames("Stepan", "Alex");
            //dbService.saveUser(user1);
            //dbService.saveUser(user2);
            dbService.saveUser(user3);
            //dbService.getUserName(3);
            List<String> names = dbService.getAllNames();
            System.out.println(names);
            System.out.println(dbService.loadUser2(2, UserDataSet.class));
            System.out.println(dbService.loadUser2(8, UserDataSet.class));
            //dbService.dropTable();

        }


    }
}
