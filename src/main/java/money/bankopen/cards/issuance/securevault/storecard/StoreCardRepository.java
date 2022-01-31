package money.bankopen.cards.issuance.securevault.storecard;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreCardRepository extends JpaRepository<StoreCardDTO,String> {
}
