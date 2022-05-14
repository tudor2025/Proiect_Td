package backend.proiect.backenddto.Appointment;

import backend.proiect.backenddto.Appointment.Models.AppointmentShow;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDbConnection {

    private Connection connection;

    public AppointmentDbConnection() {

        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useLegacyDate" +
                    "timeCode=false&serverTimezone=UTC", "root", "rootpass");
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

    public int addAppointment(int idService, String userName, String userPhoneNr,
                                  int year, int month, int day, int hour, int minute){

        try{

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?" +
                    "useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "rootpass");

            String SQL = "{?=CALL addAppointment(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement cs = connection.prepareCall(SQL);

            cs.registerOutParameter(1, Types.INTEGER);

            cs.setInt(2, 0);
            cs.setString(3, userName);
            cs.setString(4, userPhoneNr);
            cs.setInt(5, year);
            cs.setInt(6, month);
            cs.setInt(7, day);
            cs.setInt(8, hour);
            cs.setInt(9, minute);
            cs.setInt(10, idService);

            cs.execute();

            return cs.getInt(1);

        } catch (SQLException ex) {
            return 0;
        }

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

}
