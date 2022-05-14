package backend.proiect.backenddto.Appointment;

import backend.proiect.backenddto.Appointment.Models.AppointmentADD;
import backend.proiect.backenddto.Appointment.Models.AppointmentShow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentShow, Long> {

    AppointmentDbConnection appointmentDbConn = new AppointmentDbConnection();

    @Override
    default List<AppointmentShow> findAll(){
        return appointmentDbConn.getAllAppointments();
    }

    default AppointmentShow getByAppId(int id){

        return appointmentDbConn.getByAppId(id);

    }

    default int addAppointment(AppointmentADD entity){

        int ok = appointmentDbConn.addAppointment(
                entity.getIdService(),
                entity.getUserName(),
                entity.getUserPhoneNr(),
                entity.getYear(),
                entity.getMonth(),
                entity.getDay(),
                entity.getHour(),
                entity.getMinute());

        return ok;

    }

    default void acceptAppointment(int id){

        appointmentDbConn.acceptAppointment(id);

    }

    default void deleteAppointment(int id){

        appointmentDbConn.deleteAppointment(id);

    }

}
