package ReadingAndWriting.FileTypes;

import ReadingAndWriting.Interfaces.ReadingAndWriting;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class ReadingFromXML implements ReadingAndWriting {
    public String result = "";

    @Override
    public void read (String FileName) throws IOException, ParserConfigurationException, SAXException {
        File inputFile = new File(FileName);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(inputFile);

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("String");

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == nNode.ELEMENT_NODE) {
                Element string = (Element) nNode;

                result = result.concat(string.getTextContent());
                result = result.concat(" ");
            }
        }

        result = result.strip();
    }

    @Override
    public void write(String path, String text) throws ParserConfigurationException, IOException, TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.newDocument();

        Element root = doc.createElement("Strings");
        Element user = doc.createElement("String");

        root.appendChild(user);
        doc.appendChild(root);
        user.appendChild(doc.createTextNode(text));

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(doc);

        StreamResult result = new StreamResult(mkdirFiles(path));

        transformer.transform(source, result);
    }

    private File mkdirFiles(String filePath) {
        return new File(filePath);
    }
}