package backend.proiect.backenddto.Appointment;

import backend.proiect.backenddto.Appointment.Models.App;
import backend.proiect.backenddto.Appointment.Models.AppointmentShow;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDbConnection {

    private Connection connection;

    public AppointmentDbConnection() {

        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "rootpass");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<AppointmentShow> getAllAppointments() {

        List<AppointmentShow> listAppointments = new ArrayList<AppointmentShow>();

        try {

            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT " +
                            " a.Id, a.Status, a.Year, a.Month, a.Day, a.Hour, a.Minute, " +
                            " s.Name serviceName, s.Price servicePrice, s.Duration serviceDuration," +
                            " u.Name userName, u.PhoneNr userPhoneNr" +
                            "  FROM Appointment a" +
                            "   JOIN Service s" +
                            "    ON a.IdService = s.Id" +
                            "    JOIN User u" +
                            "    ON a.IdUser = u.Id;"
            );

            while(rs.next()) {
                listAppointments.add(new AppointmentShow(
                        rs.getInt("Id"),
                        rs.getInt("Status"),
                        rs.getInt("Year"),
                        rs.getInt("Month"),
                        rs.getInt("Day"),
                        rs.getInt("Hour"),
                        rs.getInt("Minute"),

                        rs.getString("userName"),
                        rs.getString("userPhoneNr"),

                        rs.getString("serviceName"),
                        rs.getString("servicePrice"),
                        rs.getString("serviceDuration")
                ));
            }
        } catch (SQLException var7) {
            System.out.println("Error Db Connection.");
        }

        return listAppointments;
    }

    public AppointmentShow getByAppId(int id) {

        try {

            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT " +
                            " a.Id, a.Status, a.Year, a.Month, a.Day, a.Hour, a.Minute, " +
                            " s.Name serviceName, s.Price servicePrice, s.Duration serviceDuration," +
                            " u.Name userName, u.PhoneNr userPhoneNr" +
                            "  FROM Appointment a" +
                            "   JOIN Service s" +
                            "    ON a.IdService = s.Id" +
                            "    JOIN User u" +
                            "    ON a.IdUser = u.Id WHERE a.Id=" + id + ";"
            );

            if(rs.next()){
                return new AppointmentShow(
                        rs.getInt("Id"),
                        rs.getInt("Status"),
                        rs.getInt("Year"),
                        rs.getInt("Month"),
                        rs.getInt("Day"),
                        rs.getInt("Hour"),
                        rs.getInt("Minute"),

                        rs.getString("userName"),
                        rs.getString("userPhoneNr"),

                        rs.getString("serviceName"),
                        rs.getString("servicePrice"),
                        rs.getString("serviceDuration")
                );
            }

        } catch (SQLException var7) {
            System.out.println("Error Db Connection.");
        }

        return null;
    }

    public List<AppointmentShow> getByUserPhoneNr(String userPhoneNr) {

        List<AppointmentShow> listAppointments = new ArrayList<AppointmentShow>();

        try {

            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT " +
                            " a.Id, a.Status, a.Year, a.Month, a.Day, a.Hour, a.Minute, " +
                            " s.Name serviceName, s.Price servicePrice, s.Duration serviceDuration," +
                            " u.Name userName, u.PhoneNr userPhoneNr" +
                            "  FROM Appointment a" +
                            "   JOIN Service s" +
                            "    ON a.IdService = s.Id" +
                            "    JOIN User u" +
                            "    ON a.IdUser = u.Id WHERE u.PhoneNr=" + userPhoneNr + ";"
            );

            while(rs.next()) {
                listAppointments.add(new AppointmentShow(
                        rs.getInt("Id"),
                        rs.getInt("Status"),
                        rs.getInt("Year"),
                        rs.getInt("Month"),
                        rs.getInt("Day"),
                        rs.getInt("Hour"),
                        rs.getInt("Minute"),

                        rs.getString("userName"),
                        rs.getString("userPhoneNr"),

                        rs.getString("serviceName"),
                        rs.getString("servicePrice"),
                        rs.getString("serviceDuration")
                ));
            }

        } catch (SQLException var7) {
            System.out.println("Error Db Connection.");
        }

        return listAppointments;
    }

    /*
    public boolean addAppointment(int idService, int idUser, int year, int month, int day, int hour, int minute){

        try{

            Statement stm1 = this.connection.createStatement();
            ResultSet rs = stm1.executeQuery("SELECT * FROM Appointment WHERE " +
                    "Year="+year+
                    " AND Month="+month+
                    " AND Day="+day+
                    " AND Hour="+hour+
                    " AND Minute="+minute);

            if(rs.next()){
                return false;
            }else{

                PreparedStatement stmt = this.connection.prepareStatement("INSERT INTO Appointment " +
                        "(idService, Status, IdUser, Year, Month, Day, Hour, Minute) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

                stmt.setInt(1, idService);
                stmt.setInt(2, 0);
                stmt.setInt(3, idUser);
                stmt.setInt(4, year);
                stmt.setInt(5, month);
                stmt.setInt(6, day);
                stmt.setInt(7, hour);
                stmt.setInt(8, minute);

                stmt.executeUpdate();

                return true;

            }

        } catch (SQLException e) {

        }
        return false;
    }

    public void acceptAppointment(int id){

        try{

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "rootpass");

            PreparedStatement stmt = con.prepareStatement("UPDATE Appointment SET Status=1 WHERE Id=(?)");

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {

        }

    }

    public void deleteAppointment(int id){

        try{

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "rootpass");

            PreparedStatement stmt = con.prepareStatement("DELETE FROM Appointment WHERE Id=(?)");

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {

        }

    }

     */

}
