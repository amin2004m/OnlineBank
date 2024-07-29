package az.bank.onlineBank.services;


import az.bank.onlineBank.dto.CardDTO;
import az.bank.onlineBank.entities.Card;
import az.bank.onlineBank.mapper.CardMapper;
import az.bank.onlineBank.repositories.CardRepository;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Data
@Service
@Validated
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class CardRequestService {
    CardRepository cardRepository;

    public Card createCard(CardDTO request){
        Card card = CardMapper.mapToEntity(request);
        return cardRepository.save(card);
    }

}
