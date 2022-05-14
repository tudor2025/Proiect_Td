package backend.proiect.backenddto.Appointment.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "AppointmentShow")
public class AppointmentShow {

    public AppointmentShow(int id, int status, int year, int month, int day, int hour, int minute, String userName, String userPhoneNr, String serviceName, String servicePrice, String serviceDuration) {
        this.id = id;
        this.status = status;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.userName = userName;
        this.userPhoneNr = userPhoneNr;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.serviceDuration = serviceDuration;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Status")
    private int status;

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


    // user data
    @Column(name = "userName")
    private String userName;

    @Column(name = "userPhoneNr")
    private String userPhoneNr;


    // service data
    @Column(name = "serviceName")
    private String serviceName;

    @Column(name = "servicePrice")
    private String servicePrice;

    @Column(name = "serviceDuration")
    private String serviceDuration;

}
