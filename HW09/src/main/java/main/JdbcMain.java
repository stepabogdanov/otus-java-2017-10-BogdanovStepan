package main;

import base.DBService;
import connnection.DBServiceConnection;

public class JdbcMain {
    public static void main(String[] args) throws Exception {
        new JdbcMain().run();

    }

    private void run() throws Exception {
        try (DBService dbService = new DBServiceConnection()) {
            System.out.println(dbService.getMetaData());
        }


    }
}
