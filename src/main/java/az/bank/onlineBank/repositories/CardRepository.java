package az.bank.onlineBank.repositories;

import az.bank.onlineBank.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {

}
