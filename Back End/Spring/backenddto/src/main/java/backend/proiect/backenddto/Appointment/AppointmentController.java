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
        return appointmentService.getByAppId(Long.valueOf(id));
    }

    @CrossOrigin(origins = "http://localhost")
    @RequestMapping(value = "/appointments/user/phoneNr", method = RequestMethod.POST)
    public List<AppointmentShowDTO> getByUserId(@RequestBody String phoneNr){
        return appointmentService.getByUserPhoneNr(phoneNr);
    }




    //Todo: AICI AM RAMAS SA FAC ADAUGAREA

    /*
    @CrossOrigin(origins = "http://localhost")
    @RequestMapping(value = "/appointments/add", method = RequestMethod.POST)
    //@ResponseStatus(code = HttpStatus.ACCEPTED, reason = "Appointment accepted.")
    public int addAppointment (@RequestBody AppointmentAddDTO appointmentAddDTO){

        if(appointmentService.addAppointment(appointmentAddDTO)){
            return 201;
            //return new ResponseEntity<>("201", HttpStatus.CREATED);
        }else{
            return 404;
            //return new ResponseEntity<>("404", HttpStatus.FORBIDDEN);
        }

    }

    @CrossOrigin(origins = "http://localhost")
    @RequestMapping(value = "/appointments/accept", method = RequestMethod.PUT)
    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "Appointment accepted.")
    public void acceptAppointment(@RequestBody IntDTO id){
        appointmentService.acceptAppointment(id);
    }

    @CrossOrigin(origins = "http://localhost")
    @RequestMapping(value = "/appointments/delete", method = RequestMethod.DELETE)
    @ResponseStatus(code = HttpStatus.OK, reason = "Appointment deleted.")
    public void deleteAppointment(@RequestBody IntDTO id){
        appointmentService.deleteAppointment(id);
    }

     */

}
