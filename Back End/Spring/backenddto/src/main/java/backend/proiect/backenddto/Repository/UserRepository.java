package backend.proiect.backenddto.Repository;

import backend.proiect.backenddto.DbConnections.UserDbConnection;
import backend.proiect.backenddto.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        System.out.println(user.getId() + " " + user.getName() + " " + user.getPhoneNr());

        return (S) new User();
    }
}
