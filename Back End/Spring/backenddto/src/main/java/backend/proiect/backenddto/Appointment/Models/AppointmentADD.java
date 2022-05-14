package backend.proiect.backenddto.Appointment.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Appointment")
public class AppointmentADD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "idService")
    private int idService;

    @Column(name = "Status")
    private int status;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userPhoneNr")
    private String userPhoneNr;

    @Column(name = "Year")
    private int year;

    @Column(name = "Month")
    private int month;

    @Column(name = "Day")
    private int day;

    @Column(name = "Hour")
    private int hour;

    @Column(name = "Minute")
    private int minute;

}
