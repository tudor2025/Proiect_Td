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
                        rs.getInt("IdUser")
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
                        rs.getInt("IdUser")
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
                        rs.getInt("IdUser")
                ));
            }
        } catch (SQLException var7) {
            System.out.println("Error Db Connection.");
        }

        return listAppointments;
    }

    public void addAppointment(int duration, int idUser){

        try{

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "rootpass");

            PreparedStatement stmt = con.prepareStatement("INSERT INTO Appointment " +
                    "(Duration, Status, IdUser) VALUES (?, ?, ?)");

            stmt.setInt(1, duration);
            stmt.setInt(2, 0);
            stmt.setInt(3, idUser);

            stmt.executeUpdate();

        } catch (SQLException e) {

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
