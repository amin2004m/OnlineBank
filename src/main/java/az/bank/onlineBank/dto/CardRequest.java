package az.bank.onlineBank.dto;

import az.bank.onlineBank.customAnnotations.Luhn;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonPropertyOrder("name"+"surname"+"docFin"+ "phoneNumber" + "pan"+"cardID")
public class CardRequest {

    Long cardID;
//
//    @NotBlank(message = "pan should not be empty")
//    @Size(min = 16, message = "Minimum size 16 !")
    @Luhn()
    String pan;

//    @NotBlank(message = "doc fin should not be empty")
//    @Size(min = 7, message = "Minimum Fin size 7")
//    String docFin;
//
//    @NotBlank(message = "name  should not be empty")
//    String name;
//
//    @NotBlank(message = "surname  should not be empty")
//    String surname;
//
//    @NotBlank(message = "phoneNumber  should not be empty")
//    @Size(min = 11,max = 12,message = "Phone number length not be short")
//    String phoneNumber;

}
