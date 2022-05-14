package backend.proiect.backenddto.Appointment;

import backend.proiect.backenddto.Appointment.DTO.AppointmentAddDTO;
import backend.proiect.backenddto.Appointment.DTO.AppointmentShowDTO;
import backend.proiect.backenddto.Appointment.Models.AppointmentADD;
import backend.proiect.backenddto.Appointment.Models.AppointmentShow;
import backend.proiect.backenddto.IntDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    public AppointmentRepository appointmentRepository;

    public List<AppointmentShowDTO> getAllUsers(){

        return appointmentRepository.findAll()
                .stream()
                .map(this::converAppointmentShowToDTO)
                .collect(Collectors.toList());

    }

    public AppointmentShowDTO getByAppId(int id){

        return converAppointmentShowToDTO(appointmentRepository.getByAppId(id));

    }

    public int addAppointment(AppointmentAddDTO appointmentAddDTO){

        int ok = appointmentRepository.addAppointment(this.convertAppointmentDTOToApp(appointmentAddDTO));

        return ok;

    }

    public void acceptAppointment(int id){
        appointmentRepository.acceptAppointment(id);
    }

    public void deleteAppointment(int id){
        appointmentRepository.deleteAppointment(id);
    }

    private AppointmentShowDTO converAppointmentShowToDTO(AppointmentShow appointmentShow){

        AppointmentShowDTO appointmentShowDTO = new AppointmentShowDTO();

        appointmentShowDTO.setStatus(appointmentShow.getStatus());
        appointmentShowDTO.setYear(appointmentShow.getYear());
        appointmentShowDTO.setMonth(appointmentShow.getMonth());
        appointmentShowDTO.setDay(appointmentShow.getDay());
        appointmentShowDTO.setHour(appointmentShow.getHour());
        appointmentShowDTO.setMinute(appointmentShow.getMinute());

        appointmentShowDTO.setUserName(appointmentShow.getUserName());
        appointmentShowDTO.setUseerPhoneNr(appointmentShow.getUserPhoneNr());

        appointmentShowDTO.setServiceName(appointmentShow.getServiceName());
        appointmentShowDTO.setServicePrice(appointmentShow.getServicePrice());
        appointmentShowDTO.setServiceDuration(appointmentShow.getServiceDuration());

        return appointmentShowDTO;
    }

    private AppointmentADD convertAppointmentDTOToApp(AppointmentAddDTO appointmentAddDTO){

        AppointmentADD appointment = new AppointmentADD();

        appointment.setIdService(appointmentAddDTO.getIdService());
        appointment.setStatus(0);

        appointment.setUserPhoneNr(appointmentAddDTO.getUserPhoneNr());
        appointment.setUserName(appointmentAddDTO.getUserName());

        appointment.setYear(appointmentAddDTO.getYear());
        appointment.setMonth(appointmentAddDTO.getMonth());
        appointment.setDay(appointmentAddDTO.getDay());
        appointment.setHour(appointmentAddDTO.getHour());
        appointment.setMinute(appointmentAddDTO.getMinute());

        return appointment;
    }

}
