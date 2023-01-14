package Tests.Encryption;

import Archives.ZipFiles;
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
        CipherFileEncoder.decryptFile(key, new File("Enc_" + testFile.getName()));

        ReadingFromTxt r = new ReadingFromTxt();
        r.read("Dec_Enc_result.txt");

        new File("result.txt").delete();
        new File("Enc_result.txt").delete();
        new File("Dec_Enc_result.txt").delete();

        assertEquals(test, r.result);
    }

    @Test
    void encryptdecryptArchive_andReadIt_thenSuccess() throws Exception {
        String test = "Testing encryption.";

        new ReadingFromTxt().write("result.txt", test);

        String key = "1234567890123456";

        new ZipFiles().archive("result.txt");

        File testFile = new File("result.zip");

        CipherFileEncoder.encryptFile(key, testFile);
        CipherFileEncoder.decryptFile(key, new File("Enc_" + testFile));
        new ZipFiles().unarchive("Dec_Enc_result.zip");

        ReadingFromTxt r = new ReadingFromTxt();
        r.read("result.txt");

        new File("result.txt").delete();
        new File("result.zip").delete();
        new File("Enc_result.zip").delete();
        new File("Dec_Enc_result.zip").delete();
        new File("Dec_Enc_result.txt").delete();

        assertEquals(test, r.result);
    }
}