package money.bankopen.cards.issuance.securevault.generateCVV;


import lombok.Data;
import money.bankopen.cards.issuance.securevault.SecurityDefaultData;

import java.util.List;

@Data
public class GenerateCVV {

    private SecurityDefaultData defaultData;

    private List<GenerateCVVServiceData> serviceData;




}
