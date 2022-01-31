package money.bankopen.cards.issuance.securevault.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssuanceResponse {
	
	Object result;
	String responseCode;
	String exception;
}
