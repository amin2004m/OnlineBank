package az.bank.onlineBank.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardRequest {

    @NotBlank(message = "pan should not be empty")
    String pan;

//    //@NotBlank(message = "doc fin should not be empty")
//    String docFin;
//
//   // @NotBlank(message = "name  should not be empty")
//    String name;
//
//   // @NotBlank(message = "surname  should not be empty")
//    String surname;
//
//    //@NotBlank(message = "phoneNumber  should not be empty")
//    String phoneNumber;

}
