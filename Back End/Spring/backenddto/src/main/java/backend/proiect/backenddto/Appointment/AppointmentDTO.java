package backend.proiect.backenddto.Appointment;

import lombok.Data;

@Data
public class AppointmentDTO {

    private int id;
    private int duration;
    private int status;
    private int idUser;

}
