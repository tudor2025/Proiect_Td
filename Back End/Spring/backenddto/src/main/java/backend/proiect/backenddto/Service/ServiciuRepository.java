package backend.proiect.backenddto.Service;

import backend.proiect.backenddto.User.Serviciu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiciuRepository extends JpaRepository<Serviciu, Long> {

    ServiciuDbConnection serviceDbConnection = new ServiciuDbConnection();

    default List<Serviciu> getAllServicies(){
        return serviceDbConnection.getAllServicies();
    }

}
