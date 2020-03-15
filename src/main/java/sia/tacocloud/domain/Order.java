package sia.tacocloud.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import sia.tacocloud.security.User;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "taco_order")
public class Order implements Serializable {

    private static final Long SERIAL_VERSION_UID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @ManyToOne
    private User user;

    private Date createdAt;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Street name is mandatory")
    private String street;

    @NotBlank(message = "City name is mandatory")
    private String city;

    @NotBlank(message = "State name is mandatory")
    private String state;

    @NotBlank(message = "Zip code is mandatory")
    private String zip;

    @CreditCardNumber(message = "Credit card number is not correct")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([/])([1-9][0-9])$", message = "Value must be in format MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Wrong CVV code")
    @Length(min = 3, message = "Wrong CVV code")
    private String ccCVV;

    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> tacos = new ArrayList<>();

    public void addDesign(Taco taco){
        this.tacos.add(taco);
    }

    @PrePersist
    void createdAt(){
        this.createdAt = new Date();
    }
}
