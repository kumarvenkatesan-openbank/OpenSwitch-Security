package money.bankopen.cards.issuance.securevault.utils;

import lombok.Getter;

public enum ResponseCodes {
	SUCCESS("I00"),
	FIELD_ERROR("I01"),
	JSON_PARSE_ERROR("I02"),
	CONFIG_ERROR("I03");
	
	@Getter
	String code;

	private ResponseCodes(String code) {
		this.code = code;
	}
	
}
