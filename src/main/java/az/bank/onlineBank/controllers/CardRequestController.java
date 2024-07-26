package az.bank.onlineBank.controllers;

import az.bank.onlineBank.dto.CardRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("v1/card")
@RestController
@Validated
public class CardRequestController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> validateCard(@Valid @RequestBody CardRequest cardRequest) {
        return ResponseEntity.ok("PAN is valid: " + cardRequest.getPan());
    }


}
