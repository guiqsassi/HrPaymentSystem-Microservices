package microservices.userapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import static jakarta.persistence.GenerationType.IDENTITY;
import lombok.EqualsAndHashCode.Include;

@Entity(name="user")
@Data @AllArgsConstructor @NoArgsConstructor 
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
  
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Include
  private long id;
  private String email;
  private String name;
  private String password;
  private Double hourlyPrice;

}
