package sia.tacocloud;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Order {
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
}
