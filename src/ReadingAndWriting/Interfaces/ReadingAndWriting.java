package ReadingAndWriting.Interfaces;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.security.GeneralSecurityException;

public interface ReadingAndWriting {
    void read(String filename) throws GeneralSecurityException, IOException, ParserConfigurationException, SAXException;
    void write(String path, String text) throws IOException, ParserConfigurationException, TransformerException;
}