package backend.proiect.backenddto.Appointment;

import backend.proiect.backenddto.IntDTO;
import backend.proiect.backenddto.User.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping(value = "/appointments", method = RequestMethod.GET)
    public List<AppointmentDTO> getAllAppointments(){
        return appointmentService.getAllUsers();

    }

    @RequestMapping(value = "/appointments/{id}", method = RequestMethod.GET)
    public AppointmentDTO getByAppId(@PathVariable int id){
        return appointmentService.getByAppId(Long.valueOf(id));
    }

    @RequestMapping(value = "/appointments/user/{id}", method = RequestMethod.GET)
    public List<AppointmentDTO> getByUserId(@PathVariable int id){
        return appointmentService.getByUserId(id);
    }


    @RequestMapping(value = "/appointments/add", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED, reason = "Appointment added to DB.")
    public void addUser(@RequestBody AppointmentAddDTO appointmentAddDTO){
        appointmentService.addAppointment(appointmentAddDTO);
    }

    @RequestMapping(value = "/appointments/accept", method = RequestMethod.PUT)
    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "Appointment accepted.")
    public void acceptAppointment(@RequestBody IntDTO id){
        appointmentService.acceptAppointment(id);
    }

    @RequestMapping(value = "/appointments/delete", method = RequestMethod.DELETE)
    @ResponseStatus(code = HttpStatus.OK, reason = "Appointment deleted.")
    public void deleteAppointment(@RequestBody IntDTO id){
        appointmentService.deleteAppointment(id);
    }

}
