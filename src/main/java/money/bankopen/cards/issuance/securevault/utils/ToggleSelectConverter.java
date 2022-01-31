package money.bankopen.cards.issuance.securevault.utils;

import javax.persistence.AttributeConverter;

public class ToggleSelectConverter implements AttributeConverter<ToggleSelect, Character> {

	@Override
	public Character convertToDatabaseColumn(ToggleSelect attribute) {
		return attribute.toString().charAt(0);
	}

	@Override
	public ToggleSelect convertToEntityAttribute(Character dbData) {		
		return ToggleSelect.valueOf(dbData.toString());
	}

}
