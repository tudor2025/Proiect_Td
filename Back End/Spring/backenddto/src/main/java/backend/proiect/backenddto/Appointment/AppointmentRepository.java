package backend.proiect.backenddto.Appointment;

import backend.proiect.backenddto.Appointment.Models.AppointmentShow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentShow, Long> {

    AppointmentDbConnection appointmentDbConn = new AppointmentDbConnection();

    @Override
    default List<AppointmentShow> findAll(){
        return appointmentDbConn.getAllAppointments();
    }

    default AppointmentShow getByAppId(Long id){

        return appointmentDbConn.getByAppId(id.intValue());

    }


    default List<AppointmentShow> getByUserPhoneNr(String userPhoneNr){

        return appointmentDbConn.getByUserPhoneNr(userPhoneNr);

    }

    /*
    default boolean addAppointment(App entity){

        return appointmentDbConn.addAppointment(
                entity.getIdService(),
                entity.getIdUser(),
                entity.getYear(),
                entity.getMonth(),
                entity.getDay(),
                entity.getHour(),
                entity.getMinute());

    }

    default void acceptAppointment(int id){

        appointmentDbConn.acceptAppointment(id);

    }

    default void deleteAppointment(int id){

        appointmentDbConn.deleteAppointment(id);

    }

     */

}
