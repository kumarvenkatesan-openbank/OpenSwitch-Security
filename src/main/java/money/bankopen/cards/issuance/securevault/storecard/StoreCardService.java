package money.bankopen.cards.issuance.securevault.storecard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreCardService {

    @Autowired
    StoreCardRepository storeCardRepository;

    public String storeCard(StoreCardDTO storeCardDTO)
    {
        return storeCardRepository.save(storeCardDTO).getId();


    }


}
