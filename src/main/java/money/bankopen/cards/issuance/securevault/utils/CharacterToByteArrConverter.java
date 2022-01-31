package money.bankopen.cards.issuance.securevault.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

@WritingConverter
@Component
public class CharacterToByteArrConverter implements Converter<Character,byte[]>{

	@Override
	public byte[] convert(Character source) {
		return source.toString().getBytes();
	}
}
