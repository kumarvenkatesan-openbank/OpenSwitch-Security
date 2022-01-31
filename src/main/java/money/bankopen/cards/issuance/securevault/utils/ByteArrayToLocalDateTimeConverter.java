package money.bankopen.cards.issuance.securevault.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@ReadingConverter
@Component
public class ByteArrayToLocalDateTimeConverter implements Converter<byte[], LocalDateTime>{

	@Override
	public LocalDateTime convert(byte[] source) {
		return LocalDateTime.parse(new String(source));
	}
}
