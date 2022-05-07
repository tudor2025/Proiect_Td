package backend.proiect.backenddto.Controller;

import backend.proiect.backenddto.DTO.UserDTO;
import backend.proiect.backenddto.Model.User;
import backend.proiect.backenddto.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }


    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public UserDTO getUserById(@PathVariable int id){
        return userService.getById(id);
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED, reason = "User added to DB.")
    public void addUser(@RequestBody UserDTO userDTO){
        userService.addUser(userDTO);
    }

}
