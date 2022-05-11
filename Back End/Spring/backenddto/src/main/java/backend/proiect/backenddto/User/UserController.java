package backend.proiect.backenddto.User;

import backend.proiect.backenddto.User.UserDTO;
import backend.proiect.backenddto.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public UserDTO getUserById(@PathVariable int id){
        return userService.getById(id);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED, reason = "User added to DB.")
    public void addUser(@RequestBody UserDTO userDTO){
        userService.addUser(userDTO);
    }

}
