package backend.proiect.backenddto.User;

import backend.proiect.backenddto.User.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDbConnection {

    public List<User> getAllUsers() {
        List<User> listUsers = new ArrayList<User>();
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?" +
                    "useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "rootpass");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM User");

            while(rs.next()) {
                listUsers.add(new User(
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getString("PhoneNr")
                ));
            }

            connection.close();
            stmt.close();
            rs.close();

        } catch (SQLException var7) {
            System.out.println("Error Db Connection.");
        }


        return listUsers;
    }

    public User getUserById(int id) {

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?" +
                    "useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "rootpass");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM User WHERE Id=" + id);

            if (rs.next()) {

                connection.close();
                stmt.close();
                rs.close();

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

    public int getIdByPhone(User user){

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?" +
                    "useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "rootpass");

            String SQL = "{?=CALL checkIfExistsAndAddIfNot(?, ?)}";
            CallableStatement cs = connection.prepareCall(SQL);

            cs.registerOutParameter(1, Types.INTEGER);

            cs.setString(2, user.getName());
            cs.setString(3, user.getPhoneNr());

            cs.execute();

            return cs.getInt(1);

        } catch (SQLException var7) {
            return -1;
        }

    }

}
