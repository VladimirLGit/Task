package eu.senla.task12.users;

import eu.senla.task12.Connector;
import eu.senla.task12.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoUserImpl implements Dao {
    private Connector conn;

    public boolean createTableUsers(){
        final String QUERY ="CREATE TABLE users (\n" +
                " id int(10) NOT NULL AUTO_INCREMENT,\n" +
                " login varchar(20) NOT NULL,\n" +
                " password varchar(24) NOT NULL,\n" +
                " PRIMARY KEY (id)\n" +
                ");";
        try(Connection con = conn.getConnection();
            Statement stmt = con.createStatement();) {
            boolean execute = stmt.execute(QUERY);
            return execute;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public DaoUserImpl() {
        conn = new Connector();
    }

    @Override
    public User create(User user) {
        return new User(user.getName(), user.getPassword());
    }

    @Override
    public User read(User user) {
        return null;
    }

    @Override
    public User read(String name, String password) {
        return null;
    }

    @Override
    public User update(String name, User newUser) {
        return null;
    }

    @Override
    public boolean delete(String name, String password) {
        return false;
    }

    @Override
    public List<User> readList() {
        List<User> users = new ArrayList<>();
        final String QUERY = "select id,login,password from Users";
        try(Connection con = conn.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY)) {

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("login");
                String password = rs.getString("password");
                users.add(new User(name, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return users;
    }

    public void readAllUsers(){
        final String QUERY = "select id,login,password from Users";
        try(Connection con = conn.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY)) {

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("login");
                String password = rs.getString("password");
                System.out.println(id + "," +name+ "," +password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
