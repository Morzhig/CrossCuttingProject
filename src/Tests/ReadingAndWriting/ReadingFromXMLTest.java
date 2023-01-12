package Tests.ReadingAndWriting;

import ReadingAndWriting.ReadingFromXML;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReadingFromXMLTest {

    @Test
    void ReadingWritingXML_Test() throws IOException, ParserConfigurationException, TransformerException, SAXException {
        File f = new File("result.xml");
        f.createNewFile();

        String test = "Testing XML Reader and Writer.";

        ReadingFromXML rfXML = new ReadingFromXML();

        rfXML.write("result.xml", test);
        rfXML.read("result.xml");

        assertEquals(test, rfXML.result);
        f.delete();
    }
}