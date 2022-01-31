package money.bankopen.cards.issuance.securevault.utils;

import java.time.format.DateTimeFormatter;

public class CommonUtils {
	/**
	 * Date time formatters
	 */
	public static final DateTimeFormatter DATE_YYYY_MM_DD = DateTimeFormatter.ISO_DATE;
	public static final DateTimeFormatter DATE_MMYYYY = DateTimeFormatter.ofPattern("MMyyyy");

	public static final DateTimeFormatter DATE_YYYY_MM_DD_HH_MM_SS_SSS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
	public static final DateTimeFormatter DATE_DDMMYYHHMMSS = DateTimeFormatter.ofPattern("ddMMyyHHmmss");
	public static final DateTimeFormatter MMYYYY = DateTimeFormatter.ofPattern("MMyyyy");
	public static final DateTimeFormatter DDMMYYYYY = DateTimeFormatter.ofPattern("ddMMyyyy");
}
