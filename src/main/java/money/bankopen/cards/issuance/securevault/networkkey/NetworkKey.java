package money.bankopen.cards.issuance.securevault.networkkey;


import lombok.Data;
import money.bankopen.cards.issuance.securevault.SecurityDefaultData;

@Data
public class NetworkKey {

    private SecurityDefaultData defaultData;
    private NetworkKeyServiceData serviceData;
   

}
