package backend.proiect.backenddto.Appointment;

import backend.proiect.backenddto.Appointment.AppointmentDbConnection;
import backend.proiect.backenddto.Appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    AppointmentDbConnection appointmentDbConn = new AppointmentDbConnection();

    @Override
    default List<Appointment> findAll(){
        return appointmentDbConn.getAllAppointments();
    }

    default Appointment getByAppId(Long id){

        return appointmentDbConn.getByAppId(id.intValue());

    }

    default List<Appointment> getByUserId(int id){

        return appointmentDbConn.getByUserId(id);

    }

    @Override
    default <S extends Appointment> S save(S entity){

        appointmentDbConn.addAppointment(entity.getDuration(), entity.getIdUser());

        return (S) new Appointment();
    }

    default void acceptAppointment(int id){

        appointmentDbConn.acceptAppointment(id);

    }

}
