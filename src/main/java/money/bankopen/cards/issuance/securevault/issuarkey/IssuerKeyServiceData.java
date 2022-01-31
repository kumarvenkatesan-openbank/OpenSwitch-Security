package money.bankopen.cards.issuance.securevault.issuarkey;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class IssuerKeyServiceData {
    @Schema(example = "#ISSUER", title = "Key id for the issuer key", required = true)
    private String keyid;
    @Schema(example = "INDEX", title = "INDEX/KEY can pass to identify the key type", required = true)
    private String keytype;
    @Schema(example = "020006", title = "Represent the value/key to send the HSM", required = true)
    private String value;

}
