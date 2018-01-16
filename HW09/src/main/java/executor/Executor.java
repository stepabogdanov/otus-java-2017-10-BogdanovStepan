package executor;

import logger.ResultHandler;
import logger.TResultHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Executor {
    private Connection connection;

    public Executor(Connection connection) {
        this.connection = connection;

    }

    public void execQuery(String query, ResultHandler handler) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(query);
            ResultSet resultSet = stmt.getResultSet();
            handler.handle(resultSet);
        }
    }

    public int execUpdate(String query) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(query);
            return stmt.getUpdateCount();
        }
    }


    public <T> T execQuery(String query, TResultHandler<T> handler) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(query);
            ResultSet resultSet = stmt.getResultSet();
            return handler.handle(resultSet);
        }

    }


}