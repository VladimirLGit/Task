package eu.senla.task12.users;

import eu.senla.task12.Connector;
import eu.senla.task12.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoUserImpl implements Dao {
    private Connector conn;

    private boolean isExistsTable(String nameTable){
        final String QUERY = "Select * FROM " + nameTable + ";";
        try (Connection con = conn.getConnection();
             Statement query =  con.createStatement();) {
            ResultSet rs = query.executeQuery(QUERY);
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }
    public boolean createTableUsers(){
        final String QUERY ="CREATE TABLE users (\n" +
                " id int(10) NOT NULL AUTO_INCREMENT,\n" +
                " login varchar(20) NOT NULL,\n" +
                " password varchar(24) NOT NULL,\n" +
                " PRIMARY KEY (id)\n" +
                ");";
        if (isExistsTable("users"))
            return false;
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
        final String QUERY = "INSERT INTO users (login, password) VALUES (?,?)";
        try (Connection con = conn.getConnection();){
           PreparedStatement preparedStatement = con.prepareStatement(QUERY);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            boolean execute = preparedStatement.execute();
            if (execute) {
                return new User(user.getName(), user.getPassword());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public User read(User user) {
        return read(user.getName(), user.getPassword());
    }

    @Override
    public User read(String name, String password) {
        final String QUERY = "Select * FROM users WHERE login = " + name +" AND password = " + password + ";";
        try (Connection con = conn.getConnection();
             Statement query =  con.createStatement();) {
            ResultSet rs = query.executeQuery(QUERY);
            if (rs.next()) {
                System.out.println("Read login as " + name);
                return new User(rs.getString("login"), rs.getString("password"));
            } else {
                System.out.println("Wrong login or password");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public User update(String name, User newUser) {
        final String QUERY = "Select * FROM users WHERE login = " + name + ";";
        try (Connection con = conn.getConnection();
             Statement query =  con.createStatement();) {
            ResultSet rs = query.executeQuery(QUERY);
            if (rs.next()) {
                String QUERY2 = "UPDATE users SET login = " + newUser.getName() +
                                ", password = " + newUser.getPassword() +
                                " WHERE login = " + name + ";";
                boolean execute = query.execute(QUERY2);
                if (execute){
                    System.out.println("Update login as " + name);
                    return new User(newUser.getName(), newUser.getPassword());
                } else {
                    System.out.println("Wrong login ");
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean delete(String name, String password) {
        final String QUERY = "Delete FROM users WHERE login = " + name +" AND password = " + password + ";";
        try (Connection con = conn.getConnection();
             Statement query =  con.createStatement();) {
            boolean execute = query.execute(QUERY);
            if (execute) {
                System.out.println("Delete login as " + name);
            } else {
                System.out.println("Wrong login or password");
            }
            return execute;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

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
