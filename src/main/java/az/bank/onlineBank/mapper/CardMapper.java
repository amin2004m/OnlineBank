package az.bank.onlineBank.mapper;

import az.bank.onlineBank.dto.CardRequest;
import az.bank.onlineBank.dto.UserDto;
import az.bank.onlineBank.entities.Card;
import az.bank.onlineBank.entities.User;

public class CardMapper {

    public static Card mapToEntity(CardRequest request) {
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
