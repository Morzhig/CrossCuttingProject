package Tests.Archives;

import Archives.ZipFiles;
import ReadingAndWriting.FileTypes.ReadingFromTxt;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZipFilesTest {
    @Test
    public void ZipArchives_Test() throws IOException {
        String test = "Zip archive.";

        new ReadingFromTxt().write("result.txt", test);

        new ZipFiles().archive("result.txt");
        new ZipFiles().unarchive("result.zip");

        ReadingFromTxt res = new ReadingFromTxt();
        res.read("result.txt");

        new File("result.txt").delete();
        new File("result.zip").delete();

        assertEquals(test, res.result);
    }
}