package Tests.ReadingAndWriting;

import ReadingAndWriting.ReadingFromTxt;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ReadingFromTxtTest {

    @Test
    void ReadingWritingTXT_Test() throws IOException {
        File f = new File("result.txt");
        f.createNewFile();

        String test = "Testing TXT Reader and Writer.";

        ReadingFromTxt rft = new ReadingFromTxt();

        rft.write("result.txt", test);
        rft.read("result.txt");

        assertEquals(test, rft.result);
        f.delete();
    }
}