package money.bankopen.cards.issuance.securevault;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SecurityDefaultData {

    @Schema(required = true,example = "ISSUANCE",title = "Request Initiator id")
    private String source;
    @Schema(required = true,example = "OPEN",title = "Partner id")
    private String partner;
    @Schema(required = true,example = "ICIC",title = "Institution Id")
    private String institution;
    @Schema(required = true,example = "01-01-2021 10:10:000",title = "Request Date",format = "timestamp")
    private String requestDate;
    @Schema(required = true,example = "ICIC-USER1",title = "User Id to Initiate request")
    private String userData;
    @Schema(required = true,example = "CARD",title = "Request Security Key id")
    private String securityKeyId;
    @Schema(required = false,example = "NETWORK",title = "Request Network Key id")
    private String networkKeyId;
    @Schema(required = false,example = "ISSUANCE",title = "Request Issuer Key id")
    private String issuerKeyId;

}

