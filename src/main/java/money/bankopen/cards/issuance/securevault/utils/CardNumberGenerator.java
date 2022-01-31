package money.bankopen.cards.issuance.securevault.utils;


import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CardNumberGenerator {

    public static String generateCardNumber(String keyData, int length, long serialNo) {
        int sequenceNumberLength = length - (keyData.length() + 1+Long.toString(serialNo).length());
        StringBuilder builder = new StringBuilder(keyData);
        builder.append("0".repeat(sequenceNumberLength));
        builder.append(serialNo);
        int checkDigit = getCheckDigit(builder.toString());
        builder.append(checkDigit);
        return builder.toString();
    }

    public static String generateSequence(String keyData,int length,long serialNo) {
        int sequenceNumberLength = length - (keyData.length() +Long.toString(serialNo).length());
        StringBuilder builder = new StringBuilder(keyData);
        builder.append("0".repeat(sequenceNumberLength));
        builder.append(serialNo);
        return builder.toString();
    }
    public static String genHash(String originalString) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(
                originalString.getBytes(StandardCharsets.UTF_8));
        String sha256hex = new String(Hex.encode(hash));
        return sha256hex;
    }

    public static String encrypt(String key,String value)
    {
        String originalInput = key+value;
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        return encodedString;
    }

    public static String decrypt(String key,String value)
    {
        byte[] decodedBytes = Base64.getDecoder().decode(key+value);
        String decodedString = new String(decodedBytes);
        return decodedString;
    }


    static String MASK_FORMAT="xxxx-xxxx-xxxx-####";
    public static String maskCardNumber(String cardNumber) {
   int index = 0;
        StringBuilder maskedNumber = new StringBuilder();
        for (int i = 0; i < MASK_FORMAT.length(); i++) {
            char c = MASK_FORMAT.charAt(i);
            if (c == '#') {
                maskedNumber.append(cardNumber.charAt(index));
                index++;
            } else if (c == 'x') {
                maskedNumber.append(c);
                index++;
            } else {
                maskedNumber.append(c);
            }
        }
        return maskedNumber.toString();
    }

	
    private static int getCheckDigit(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            int digit = Integer.parseInt(number.substring(i, (i + 1)));
            if ((i % 2) == 0) {
                digit = digit * 2;
                if (digit > 9) {
                    digit = (digit / 10) + (digit % 10);
                }
            }
            sum += digit;
        }
        int mod = sum % 10;
        return ((mod == 0) ? 0 : 10 - mod);
    }
    
    public static void main(String[] args) {
		
    	CardNumberGenerator a = new CardNumberGenerator();
    	System.out.println(generateCardNumber("12345601", 16,59));
    	System.out.println(a.getCheckDigit("123456010000059"));
    	
	}
}