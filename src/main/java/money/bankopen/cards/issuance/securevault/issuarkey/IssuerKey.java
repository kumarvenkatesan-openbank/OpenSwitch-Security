package money.bankopen.cards.issuance.securevault.issuarkey;


import lombok.Data;
import money.bankopen.cards.issuance.securevault.SecurityDefaultData;

@Data
public class IssuerKey {

    private SecurityDefaultData defaultData;
    private IssuerKeyServiceData serviceData;


}
