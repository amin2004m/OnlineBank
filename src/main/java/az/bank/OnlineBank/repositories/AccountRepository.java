package az.bank.OnlineBank.repositories;

import az.bank.OnlineBank.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
