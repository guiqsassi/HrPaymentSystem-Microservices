package microservices.payment.Controllers;

import microservices.payment.Domain.Payroll;
import microservices.payment.Domain.User;
import microservices.payment.FeingClients.UserFeign;
import microservices.payment.services.PayrollServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Payroll")
public class PayrollController {

    @Autowired
    PayrollServices services;

    @GetMapping("/{idUser}")
    public ResponseEntity<Payroll> read(@PathVariable Long idUser, @RequestBody Payroll payment){

        Payroll res = services.getPayroll(idUser, payment);
        return ResponseEntity.ok(res);
    }

}
