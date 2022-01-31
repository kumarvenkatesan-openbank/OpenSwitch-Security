package money.bankopen.cards.issuance.securevault.verifycvv;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class VerifyCVVResponse {

        @Schema(example = "00", title = "00,01 etc : Refer HSM response code", required = true)
        private String response;

}
