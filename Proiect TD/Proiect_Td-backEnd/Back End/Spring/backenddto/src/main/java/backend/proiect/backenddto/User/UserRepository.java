package backend.proiect.backenddto.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDbConnection userDbConnection = new UserDbConnection();

    @Override
    default List<User> findAll(){
        return userDbConnection.getAllUsers();
    }

    @Override
    default User getById(Long id){
        return userDbConnection.getUserById(id.intValue());
    }

    @Override
    default <S extends User> S save(S user){

        userDbConnection.addUser(user.getName(), user.getPhoneNr());

        return (S) new User();
    }
}
