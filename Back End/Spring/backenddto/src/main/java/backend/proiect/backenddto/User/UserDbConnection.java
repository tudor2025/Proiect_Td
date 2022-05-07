package backend.proiect.backenddto.User;

import backend.proiect.backenddto.User.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDbConnection {

    private Connection connection;

    public UserDbConnection() {

        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "rootpass");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> listUsers = new ArrayList<User>();
        try {

            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM User");

            while(rs.next()) {
                listUsers.add(new User(
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getString("PhoneNr")
                ));
            }
        } catch (SQLException var7) {
            System.out.println("Error Db Connection.");
        }

        return listUsers;
    }

    public User getUserById(int id){

        try {

            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM User WHERE Id=" + id);

            if(rs.next()){
                 return new User(
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getString("PhoneNr")
                );
            }

        } catch (SQLException var7) {
            System.out.println("Error Db Connection.");
        }

        return null;
    }

    public void addUser(String name, String phoneNr){

        try{

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "rootpass");

            PreparedStatement stmt = con.prepareStatement("INSERT INTO User (Name, PhoneNr) VALUES (?, ?)");

            stmt.setString(1, name);
            stmt.setString(2, phoneNr);

            stmt.executeUpdate();

        } catch (SQLException e) {

        }

    }

}
