package backend.proiect.backenddto.Service;

import backend.proiect.backenddto.User.UserDTO;
import backend.proiect.backenddto.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiciuController {

    private final ServiciuService serviciuService;

    @Autowired
    public ServiciuController(ServiciuService serviciuService) {
        this.serviciuService = serviciuService;
    }

    @CrossOrigin(origins = "http://localhost")
    @RequestMapping(value = "/servicies", method = RequestMethod.GET)
    public List<ServiciuDTO> getAllUsers(){
        return serviciuService.getAllServicies();
    }

}
