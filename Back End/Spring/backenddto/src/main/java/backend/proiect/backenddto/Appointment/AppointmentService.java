package backend.proiect.backenddto.Appointment;

import backend.proiect.backenddto.Appointment.DTO.AppointmentAddDTO;
import backend.proiect.backenddto.Appointment.DTO.AppointmentShowDTO;
import backend.proiect.backenddto.Appointment.Models.App;
import backend.proiect.backenddto.Appointment.Models.AppointmentShow;
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

    public AppointmentShowDTO getByAppId(Long id){

        return converAppointmentShowToDTO(appointmentRepository.getByAppId(id));

    }

    public List<AppointmentShowDTO> getByUserPhoneNr(String userPhoneNr){

        return appointmentRepository.getByUserPhoneNr(userPhoneNr)
                .stream()
                .map(this::converAppointmentShowToDTO)
                .collect(Collectors.toList());

    }

    /*
    public boolean addAppointment(AppointmentAddDTO appointmentAddDTO){

        return appointmentRepository.addAppointment(this.convertAppointmentDTOToApp(appointmentAddDTO));

    }

    public void acceptAppointment(IntDTO id){
        appointmentRepository.acceptAppointment(id.getId());
    }

    public void deleteAppointment(IntDTO id){
        appointmentRepository.deleteAppointment(id.getId());
    }
    */

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

    private App convertAppointmentDTOToApp(AppointmentAddDTO appointmentAddDTO){

        App appointment = new App();

        appointment.setIdService(appointmentAddDTO.getIdService());
        appointment.setStatus(0);
        appointment.setIdUser(appointmentAddDTO.getIdUser());
        appointment.setYear(appointmentAddDTO.getYear());
        appointment.setMonth(appointmentAddDTO.getMonth());
        appointment.setDay(appointmentAddDTO.getDay());
        appointment.setHour(appointmentAddDTO.getHour());
        appointment.setMinute(appointmentAddDTO.getMinute());

        return appointment;
    }

}
