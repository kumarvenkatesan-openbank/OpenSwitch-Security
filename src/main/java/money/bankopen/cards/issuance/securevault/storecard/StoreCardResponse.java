package money.bankopen.cards.issuance.securevault.storecard;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class StoreCardResponse {

        @Schema(example = "#fwsgsgsdgdsert3245325324354", title = "Hashed Card Number", required = true)
        private String hashedCardNumber;

}
