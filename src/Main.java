import Archives.ZipFiles;
import ReadingAndWriting.ReadingFromJson;
import ReadingAndWriting.ReadingFromTxt;

import java.io.IOException;

public class Main {
    private static final String FileToZipName = "Zip_Test.txt";
    private static final String ZipToFileName = "File_Test.zip";

    private static final String TxtInputFileName = "input.txt";
    private static final String TxtOutputFileName = "output.txt";

    private static final String JsonInputFileName = "input.json";
    private static final String JsonOutputFileName = "output.json";

    public static void main(String[] args) throws IOException {
        System.out.println("Checking Reading and Writing abilities...");

        System.out.println("\nChecking Reading and Writing abilities of TXT...");

        ReadingFromTxt rft = new ReadingFromTxt();

        rft.read(TxtInputFileName);
        rft.write(TxtOutputFileName);

        System.out.println("\nChecking Reading and Writing abilities of JSON...");

        ReadingFromJson rfj = new ReadingFromJson();

        rfj.read(JsonInputFileName);
        rfj.write(JsonOutputFileName);

//        System.out.println("\nChecking Reading and Writing abilities of XML...");
//
//        ReadingFromXML rfXML = new ReadingFromXML();
//
//        rfXML.read(XMLInputFileName);
//        rfXML.write(XMLOutputFileName);

        System.out.println("\nChecking Zip-archieving...");

        ZipFiles zf = new ZipFiles();

        zf.write_to_zip(FileToZipName);
        zf.read_from_zip(ZipToFileName);
    }
}
