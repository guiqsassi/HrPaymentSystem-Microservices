package microservices.userapi.Services;


import microservices.userapi.Exceptions.ObjectNotFoundException;
import microservices.userapi.domain.User;
import microservices.userapi.repositories.UserRepository;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserRepository repository;
    @Autowired
    Environment environment;

    public User createUser(User user) {
        return repository.save(user);
    }

    public  User read(Long id) {
        log.info("Payroll service ::: Get request on: "+ environment.getProperty("local.server.port") + " port");

        return repository.findById(id).orElseThrow( () -> new ObjectNotFoundException("User not found"));
    }

    public List<User> list() {
        return repository.findAll();
    }
    public Boolean delete(Long id){
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
    public User update(User user) {
        if(repository.existsById(user.getId())) {
            return repository.save(user);
        }
        return  null;

    }

}
