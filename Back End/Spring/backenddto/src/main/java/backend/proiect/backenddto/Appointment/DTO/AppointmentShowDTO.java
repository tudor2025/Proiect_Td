package backend.proiect.backenddto.Appointment.DTO;

import lombok.Data;

@Data
public class AppointmentShowDTO {

    private int status;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    private String userName;
    private String useerPhoneNr;

    private String serviceName;
    private String servicePrice;
    private String serviceDuration;

}
