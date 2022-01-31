package money.bankopen.cards.issuance.securevault.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

@ReadingConverter
@Component
public class ByteArrToCharacterConverter implements Converter<byte[],Character>{

	@Override
	public Character convert(byte[] source) {
		return new String(source).charAt(0);
	}
}
