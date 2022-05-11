package backend.proiect.backenddto.Appointment;

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

    public List<Appointment> getAllAppointments() {
        List<Appointment> listAppointments = new ArrayList<Appointment>();
        try {

            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Appointment");

            while(rs.next()) {
                listAppointments.add(new Appointment(
                        rs.getInt("Id"),
                        rs.getInt("Duration"),
                        rs.getInt("Status"),
                        rs.getInt("IdUser"),
                        rs.getInt("Year"),
                        rs.getInt("Month"),
                        rs.getInt("Day"),
                        rs.getInt("Hour"),
                        rs.getInt("Minute")
                ));
            }
        } catch (SQLException var7) {
            System.out.println("Error Db Connection.");
        }

        return listAppointments;
    }

    public Appointment getByAppId(int id) {

        try {

            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Appointment WHERE Id=" + id);

            if(rs.next()){
                return new Appointment(
                        rs.getInt("Id"),
                        rs.getInt("Duration"),
                        rs.getInt("status"),
                        rs.getInt("IdUser"),
                        rs.getInt("Year"),
                        rs.getInt("Month"),
                        rs.getInt("Day"),
                        rs.getInt("Hour"),
                        rs.getInt("Minute")
                );
            }

        } catch (SQLException var7) {
            System.out.println("Error Db Connection.");
        }

        return null;
    }

    public List<Appointment> getByUserId(int id) {
        List<Appointment> listAppointments = new ArrayList<Appointment>();
        try {

            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Appointment WHERE IdUser=" + id);

            while(rs.next()) {
                listAppointments.add(new Appointment(
                        rs.getInt("Id"),
                        rs.getInt("Duration"),
                        rs.getInt("Status"),
                        rs.getInt("IdUser"),
                        rs.getInt("Year"),
                        rs.getInt("Month"),
                        rs.getInt("Day"),
                        rs.getInt("Hour"),
                        rs.getInt("Minute")
                ));
            }
        } catch (SQLException var7) {
            System.out.println("Error Db Connection.");
        }

        return listAppointments;
    }

    public boolean addAppointment(int duration, int idUser, int year, int month, int day, int hour, int minute){

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
                        "(Duration, Status, IdUser, Year, Month, Day, Hour, Minute) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

                stmt.setInt(1, duration);
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

}
