package main;

import base.DBService;
import connnection.DBServiceConnection;
import connnection.DBServiceUpdate;

import java.util.List;

public class JdbcMain {
    public static void main(String[] args) throws Exception {
        new JdbcMain().run();

    }

    private void run() throws Exception {
        //try (DBService dbService = new DBServiceConnection())
        try (DBService dbService = new DBServiceUpdate())

        {
            System.out.println(dbService.getMetaData());
            dbService.prepareTables();
            dbService.insertUsers("Stepan" , "Alex");
            dbService.getUserName(3);
            List<String> names = dbService.getAllNames();
            for (String name : names) {
                System.out.println(name);
            }
            //dbService.dropTable();
        }


    }
}
