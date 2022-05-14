package backend.proiect.backenddto.Service;

import backend.proiect.backenddto.User.Serviciu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiciuService {

    @Autowired
    public ServiciuRepository serviceRepository;

    public List<ServiciuDTO> getAllServicies(){

        return serviceRepository.getAllServicies()
                .stream()
                .map(this::convertServiceToDTO)
                .collect(Collectors.toList());

    }

    private ServiciuDTO convertServiceToDTO(Serviciu service){

        ServiciuDTO serviciuDTO = new ServiciuDTO();

        serviciuDTO.setId(service.getId());
        serviciuDTO.setName(service.getName());
        serviciuDTO.setDuration(service.getDuration());
        serviciuDTO.setPrice(service.getPrice());

        return serviciuDTO;
    }

}
