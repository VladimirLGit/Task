package eu.senla.task12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connector {
    private final String USERNAME = "root";
    private final String PASSWORD = "root";
    private final String DB_URL = "jdbc:mysql://127.0.0.1:3306/users";
    private Connection connection = null;
    public PreparedStatement preparedStatement = null;

    public Connector() throws ClassNotFoundException {
        // Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    public boolean createTableUsers(){
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(
                    "CREATE TABLE users (\n" +
                            " id int(10) NOT NULL AUTO_INCREMENT,\n" +
                            " login varchar(20) NOT NULL,\n" +
                            " password varchar(24) NOT NULL,\n" +
                            " PRIMARY KEY (id)\n" +
                            ");");
            boolean execute = preparedStatement.execute();
            connection.close();
            return execute;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
