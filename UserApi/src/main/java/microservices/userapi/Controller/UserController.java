package microservices.userapi.Controller;

import microservices.userapi.Services.UserService;
import microservices.userapi.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity create(@RequestBody User user){
        User userCreated = userService.createUser(user);
        return ResponseEntity.ok(userCreated);

    };

    @GetMapping
    public ResponseEntity getAll(){
        List<User> users = new ArrayList<User>();
        users = userService.list();

        return ResponseEntity.ok(users);

    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        User userRead = userService.read(id);

        return ResponseEntity.ok(userRead);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping
    public ResponseEntity update(@RequestBody User user){
        User userUpdated = userService.update(user);
        return ResponseEntity.ok(userUpdated);
    }
}
