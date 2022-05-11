package backend.proiect.backenddto.Appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Duration")
    private int duration;

    @Column(name = "Status")
    private int status;

    @Column(name = "IdUser")
    private int idUser;

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
