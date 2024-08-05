package az.bank.onlineBank.controllers;

import az.bank.onlineBank.dto.CardDTO;
import az.bank.onlineBank.entities.Card;
import az.bank.onlineBank.services.CardRequestService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Data
@Validated
@RestController
@RequestMapping("v1/card")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CardRequestController {
    CardRequestService cardRequestService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Card createPan(@RequestBody @Valid CardDTO card) {
        return cardRequestService.createCard(card);
    }


}
