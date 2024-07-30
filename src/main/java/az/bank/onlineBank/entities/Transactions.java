package az.bank.onlineBank.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long transactionsId;
    BigDecimal amount;

    String type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    Account account;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    List<User> users;

}