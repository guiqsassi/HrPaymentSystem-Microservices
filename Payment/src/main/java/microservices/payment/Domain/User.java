package microservices.payment.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class User {

  private long id;
  private String email;
  private String name;
  private String password;
  private Double hourlyPrice;

}
