package Tests.ReadingAndWriting;

import ReadingAndWriting.ReadingFromJson;
import ReadingAndWriting.ReadingFromTxt;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReadingFromJsonTest {

    @Test
    void ReadingWritingJson_Test() throws IOException {
        File f = new File("result.json");
        f.createNewFile();

        String test = "Testing JSON Reader and Writer.";

        ReadingFromJson rfj = new ReadingFromJson();

        rfj.write("result.json", test);
        rfj.read("result.json");

        assertEquals(test, rfj.result);
        f.delete();
    }
}