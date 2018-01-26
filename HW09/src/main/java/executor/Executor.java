package executor;

import handler.ResultHandler;
import handler.TResultHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

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

    public void execPreparedQuery(String update, PResultHandler prepare) throws SQLException {
        try {
            PreparedStatement pStatement = connection.prepareStatement(update);
            prepare.accept(pStatement);
            pStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public <E> E execPreparedQuery(String query, PResultHandlerT<E> prepare) throws SQLException {
        try {
            PreparedStatement pStatement = connection.prepareStatement(query);
            //ResultSet resultSet = prepare.accept(pStatement);
            pStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    @FunctionalInterface
    public interface PResultHandler {
        void accept(PreparedStatement statement) throws SQLException;
    }


    @FunctionalInterface
    public interface PResultHandlerT<T> {
        T accept(PreparedStatement statement) throws SQLException;
    }
}