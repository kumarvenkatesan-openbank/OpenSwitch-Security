package money.bankopen.cards.issuance.securevault.verifycvv;


import lombok.Data;
import money.bankopen.cards.issuance.securevault.SecurityDefaultData;

@Data
public class VerifyCVV {

    private SecurityDefaultData defaultData;

    private VerifyCVVServiceData serviceData;


}
