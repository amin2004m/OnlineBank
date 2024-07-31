package az.bank.onlineBank.mapper;

import az.bank.onlineBank.dto.CardDTO;
import az.bank.onlineBank.entities.Card;

public class CardMapper {

    public static Card mapToEntity(CardDTO request) {

        return Card.builder()
                .cardID(request.getCardID())
                .pan(request.getPan())
                .docFin(request.getDocFin())
                .name(request.getName())
                .surname(request.getSurname())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }
}
