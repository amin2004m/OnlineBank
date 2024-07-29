package az.bank.onlineBank.mapper;

import az.bank.onlineBank.dto.CardDTO;
import az.bank.onlineBank.entities.Card;

public class CardMapper {

    public static Card mapToEntity(CardDTO request) {
        Card card = new Card();
        card.setCardID(request.getCardID());
        card.setPan(request.getPan());
//        card.setDocFin(request.getDocFin());
//        card.setName(request.getName());
//        card.setSurname(request.getSurname());
//        card.setPhoneNumber(request.getPhoneNumber());
        return card;
    }
//    public static User mapToUserDto(UserDto userDto){
//
//
//    }
}
