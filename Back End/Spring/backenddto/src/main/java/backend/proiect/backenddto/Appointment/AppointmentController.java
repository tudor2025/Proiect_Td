package backend.proiect.backenddto.Appointment;

import backend.proiect.backenddto.Appointment.DTO.AppointmentAddDTO;
import backend.proiect.backenddto.Appointment.DTO.AppointmentShowDTO;
import backend.proiect.backenddto.IntDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;


    @CrossOrigin(origins = "http://localhost")
    @RequestMapping(value = "/appointments", method = RequestMethod.GET)
    public List<AppointmentShowDTO> getAllAppointments(){
        return appointmentService.getAllUsers();
    }

    @CrossOrigin(origins = "http://localhost")
    @RequestMapping(value = "/appointments/{id}", method = RequestMethod.GET)
    public AppointmentShowDTO getByAppId(@PathVariable int id){
        return appointmentService.getByAppId(id);
    }

    @CrossOrigin(origins = "http://localhost")
    @RequestMapping(value = "/appointments/add", method = RequestMethod.POST)
    public int addAppointment (@RequestBody AppointmentAddDTO appointmentAddDTO){

        return appointmentService.addAppointment(appointmentAddDTO);

    }

    @CrossOrigin(origins = "http://localhost")
    @RequestMapping(value = "/appointments/accept/{id}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "Appointment accepted.")
    public void acceptAppointment(@PathVariable int id){
        appointmentService.acceptAppointment(id);
    }

    @CrossOrigin(origins = "http://localhost")
    @RequestMapping(value = "/appointments/delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "Appointment deleted.")
    public void deleteAppointment(@PathVariable int id){
        appointmentService.deleteAppointment(id);
    }

}
