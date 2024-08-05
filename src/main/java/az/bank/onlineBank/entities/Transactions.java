package az.bank.onlineBank.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

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
            @Column(name = "transaction_ID")
    Long transactionsId;
    BigDecimal amount;

    String type;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    Account account;

}