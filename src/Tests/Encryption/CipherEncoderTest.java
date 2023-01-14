package Tests.Encryption;

import Encryption.CipherEncoder;
import ReadingAndWriting.FileTypes.ReadingFromTxt;
import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CipherEncoderTest {

    @Test
    void givenString_whenEncrypt_thenSuccess() throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {

        String test = "Encryption";
        String key = "1234567890123456";

        String cipherText = CipherEncoder.encrypt(key, test);
        String plainText = CipherEncoder.decrypt(key, cipherText);

        assertEquals(test, plainText);
    }
}