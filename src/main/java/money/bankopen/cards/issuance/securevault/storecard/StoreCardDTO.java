package money.bankopen.cards.issuance.securevault.storecard;

import lombok.Data;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Entity
@Data
@Table(name="card_vault")
public class StoreCardDTO  implements Persistable<String>{
    @Id
    @Column(name = "card_hash", nullable = false)
    private String id;

    @Column(name = "card_enc", nullable = false)
    private String encrCard;


    @Override
    public boolean isNew() {
        return true;
    }
}
