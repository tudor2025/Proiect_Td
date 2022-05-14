package backend.proiect.backenddto.Service;

import backend.proiect.backenddto.User.Serviciu;
import backend.proiect.backenddto.User.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiciuDbConnection {

    private Connection connection;

    public ServiciuDbConnection() {

        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "rootpass");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Serviciu> getAllServicies() {
        List<Serviciu> listServicies = new ArrayList<Serviciu>();
        try {

            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Service");

            while(rs.next()) {
                listServicies.add(new Serviciu(
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getFloat("Price"),
                        rs.getInt("Duration")
                ));
            }

            stmt.close();
            rs.close();

            return listServicies;

        } catch (SQLException var7) {
            System.out.println("Error Db Connection.");
        }

        return listServicies;
    }

}
