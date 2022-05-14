package backend.proiect.backenddto.Appointment.DTO;

import lombok.Data;

@Data
public class AppointmentAddDTO {

    private int idService;

    private String userName;
    private String userPhoneNr;

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

}
