package microservices.payment.services;


import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import microservices.payment.Domain.Payroll;
import microservices.payment.Domain.User;
import microservices.payment.Exceptions.ObjectNotFoundException;
import microservices.payment.FeingClients.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PayrollServices {

    @Autowired
    UserFeign userFeign;
    @Autowired
    private Environment environment;

    public Payroll getPayroll(Long userId, Payroll payment){
        log.info("Payroll service ::: Get request on: "+ environment.getProperty("local.server.port") + " port");
        User user = userFeign.read(userId).getBody();
        Payroll res = new Payroll();

        try {
            res.setDescription(payment.getDescription());
            res.setHourlyPrice(user.getHourlyPrice());
            res.setWorkedHours(payment.getWorkedHours());
            res.setTotalPayment(user.getHourlyPrice() * payment.getWorkedHours());
            res.setWorkerName(user.getName());

            return res;
        } catch (FeignException.NotFound e) {
            throw new ObjectNotFoundException("Object not found");
        } catch (Exception e) {
            throw new IllegalArgumentException("Argumento não autorizado");
        }

    }

}
