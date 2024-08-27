package microservices.payment.FeingClients;

import microservices.payment.Domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "UserApi")
public interface UserFeign {

    @GetMapping("/User/{id}")
    public ResponseEntity<User> read(@PathVariable Long id);

    @GetMapping("/User")
    public ResponseEntity<User> list();
}
