package money.bankopen.cards.issuance.securevault.generateCVV;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenerateCVVServiceData {

    @Schema(example = "CVV1", title = "CVV1,CVV2,ICVV any value allowed", required = true)
    private String type;
    @Schema(example = "123", title = "cvv value", required = true)
    private String cvv;
    @Schema(example = "1234561111111111", title = "PAN Data", required = true)
    private String pan;
    @Schema(example = "0221", title = "MMYY/YYMM based on the requirement", required = true)
    private String expiryDate;
    @Schema(example = "620", title = "Service code based on the requirement", required = true)
    private String serviceCode;
}
