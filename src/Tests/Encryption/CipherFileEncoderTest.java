package Tests.Encryption;

import Encryption.CipherFileEncoder;
import ReadingAndWriting.FileTypes.ReadingFromTxt;
import org.junit.jupiter.api.Test;


import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class CipherFileEncoderTest {
    @Test
    void givenFile_whenEncrypt_thenSuccess() throws Exception {
        String test = "Testing encryption.";

        new ReadingFromTxt().write("result.txt", test);

        String key = "1234567890123456";

        File testFile = new File("result.txt");

        CipherFileEncoder.encryptFile(key, testFile);
        CipherFileEncoder.decryptFile(key, new File("Dec_Enc_" + testFile.getName()));

        ReadingFromTxt r = new ReadingFromTxt();
        r.read("Dec_result.txt");

        new File("result.txt").delete();
        new File("Enc_result.txt").delete();
        new File("Dec_result.txt").delete();

        assertEquals(test, r.result);
    }
}