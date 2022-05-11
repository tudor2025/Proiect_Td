package backend.proiect.backenddto.Appointment;

import backend.proiect.backenddto.Appointment.DTO.AppointmentAddDTO;
import backend.proiect.backenddto.Appointment.DTO.AppointmentDTO;
import backend.proiect.backenddto.IntDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    public AppointmentRepository appointmentRepository;

    public List<AppointmentDTO> getAllUsers(){

        return appointmentRepository.findAll()
                .stream()
                .map(this::converAppointmentToDTO)
                .collect(Collectors.toList());

    }

    public AppointmentDTO getByAppId(Long id){

        return converAppointmentToDTO(appointmentRepository.getByAppId(id));

    }

    public List<AppointmentDTO> getByUserId(int id){

        return appointmentRepository.getByUserId(id)
                .stream()
                .map(this::converAppointmentToDTO)
                .collect(Collectors.toList());

    }

    public boolean addAppointment(AppointmentAddDTO appointmentAddDTO){

        return appointmentRepository.addAppointment(this.convertAppointmentDTOToApp(appointmentAddDTO));

    }

    public void acceptAppointment(IntDTO id){
        appointmentRepository.acceptAppointment(id.getId());
    }

    public void deleteAppointment(IntDTO id){
        appointmentRepository.deleteAppointment(id.getId());
    }

    private AppointmentDTO converAppointmentToDTO(Appointment appointment){

        AppointmentDTO appointmentDTO = new AppointmentDTO();

        appointmentDTO.setId(appointment.getId());
        appointmentDTO.setDuration(appointment.getDuration());
        appointmentDTO.setStatus(appointment.getStatus());
        appointmentDTO.setIdUser(appointment.getIdUser());
        appointmentDTO.setYear(appointment.getYear());
        appointmentDTO.setMonth(appointment.getMonth());
        appointmentDTO.setDay(appointment.getDay());
        appointmentDTO.setHour(appointment.getHour());
        appointmentDTO.setMinute(appointment.getMinute());

        return appointmentDTO;
    }

    private Appointment convertAppointmentDTOToApp(AppointmentAddDTO appointmentAddDTO){

        Appointment appointment = new Appointment();

        appointment.setDuration(appointmentAddDTO.getDuration());
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
