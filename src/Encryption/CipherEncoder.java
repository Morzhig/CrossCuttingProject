package Encryption;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CipherEncoder {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    public static String encrypt(String key, String input) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);

        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] cipherText = cipher.doFinal(input.getBytes());

        return Base64.getEncoder()
                .encodeToString(cipherText);
    }

    public static String decrypt(String key, String cipherText) throws NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);

        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] plainText = cipher.doFinal(Base64.getDecoder()
                .decode(cipherText));

        return new String(plainText);
    }
}
