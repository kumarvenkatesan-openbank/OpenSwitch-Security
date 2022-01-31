package money.bankopen.cards.issuance.securevault.storecard;


import lombok.Data;
import money.bankopen.cards.issuance.securevault.SecurityDefaultData;

@Data
public class StoreCard {

    private SecurityDefaultData defaultData;
    private StoreCardServiceData serviceData;


}
