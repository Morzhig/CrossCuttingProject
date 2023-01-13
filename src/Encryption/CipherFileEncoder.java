package Encryption;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CipherFileEncoder {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    public static void encryptFile(String key, File inputFile) throws Exception {
        try {
            SecretKey secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            FileInputStream inputStream = new FileInputStream(inputFile);
            FileOutputStream outputStream = new FileOutputStream("Enc_" + inputFile.getName());

            byte[] outputBytes = cipher.doFinal(inputStream.readAllBytes());

            outputStream.write(Base64.getEncoder().encode(outputBytes));

            inputStream.close();
            outputStream.close();

        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                 | InvalidKeyException | BadPaddingException
                 | IllegalBlockSizeException | IOException ex) {
            throw new Exception("Error encrypting file", ex);
        }
    }

    public static void decryptFile(String key, File inputFile) throws Exception {
        try {
            SecretKey secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            FileInputStream inputStream = new FileInputStream(inputFile);
            FileOutputStream outputStream = new FileOutputStream("Dec_" + inputFile.getName());

            byte[] outputBytes = cipher.doFinal(Base64.getDecoder().decode(inputStream.readAllBytes()));

            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                 | InvalidKeyException | BadPaddingException
                 | IllegalBlockSizeException | IOException ex) {
            throw new Exception("Error decrypting file", ex);
        }
    }
}
