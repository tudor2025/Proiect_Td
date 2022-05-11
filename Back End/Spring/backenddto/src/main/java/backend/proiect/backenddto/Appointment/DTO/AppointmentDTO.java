package backend.proiect.backenddto.Appointment.DTO;

import lombok.Data;

@Data
public class AppointmentDTO {

    private int id;
    private int duration;
    private int status;
    private int idUser;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

}
