package backend.proiect.backenddto.Service;

import backend.proiect.backenddto.DTO.UserDTO;
import backend.proiect.backenddto.Model.User;
import backend.proiect.backenddto.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public List<UserDTO> getAllUsers(){
        // user -> userDTO
        return userRepository.findAll()
                .stream()
                .map(this::convertUserToDTO)
                .collect(Collectors.toList());

    }

    public UserDTO getById(long id){
        return this.convertUserToDTO(userRepository.getById(id));
    }

    public User addUser(UserDTO userDTO){

        return userRepository.save(this.convertUserDTOToUser(userDTO));

    }

    private UserDTO convertUserToDTO(User user){

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setPhoneNr(user.getPhoneNr());

        return userDTO;
    }

    private User convertUserDTOToUser(UserDTO userDTO){

        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setPhoneNr(userDTO.getPhoneNr());

        return user;
    }

}
