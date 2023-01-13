import Archives.ZipFiles;
import Encryption.CipherFileEncoder;
import ReadingAndWriting.FileTypes.ReadingFromJson;
import ReadingAndWriting.FileTypes.ReadingFromTxt;
import ReadingAndWriting.FileTypes.ReadingFromXML;

import java.io.File;
import java.util.Scanner;

public class Main {
    private static final String TxtOutputFileName = "output.txt";

    private static final String JsonOutputFileName = "output.json";

    private static final String XMLOutputFileName = "output.xml";

    private static final String encKey = "1234567890123456";


    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        String path;
        int key;

        System.out.println("Welcome to Console UI this project!");

        while (true) {
            System.out.println("""
                    Here are some features for you to see:
                    Reading and writing files - 1;
                    Archiving and unarchiving zip files - 2;
                    Encrypting and decrypting files - 3;
                    Leave - 4.""");

            key = in.nextInt();

            if (key == 4)
                break;

            if (key == 1) {
                while (true) {
                    System.out.println("\nProcessing Reading and Writing");
                    System.out.println("""
                            What type of files you would like to work with:\s
                            Txt - 1
                            JSON - 2
                            XML - 3
                            Get back - 4""");

                    key = in.nextInt();

                    if (key == 4)
                        break;

                    if (key == 1) {
                        System.out.println("\nProcessing Reading and Writing of TXT...");
                        System.out.println("Enter path to a file you want to read: ");
                        path = in.next();
                        ReadingFromTxt rft = new ReadingFromTxt();
                        rft.read(path);
                        System.out.println("Result of reading input.txt is: " + rft.result);

                        System.out.println("What would you like to write into output.txt: ");
                        rft.write(TxtOutputFileName, in.next());
                    }

                    if (key == 2) {
                        System.out.println("\nChecking Reading and Writing of JSON...");
                        System.out.println("Enter path to a file you want to read: ");
                        path = in.next();
                        ReadingFromJson rfj = new ReadingFromJson();
                        rfj.read(path);
                        System.out.println("Result of reading input.json is: " + rfj.result);

                        System.out.println("What would you like to write into output.json: ");
                        rfj.write(JsonOutputFileName, in.next());
                    }

                    if (key == 3) {
                        System.out.println("\nChecking Reading and Writing of XML...");
                        System.out.println("Enter path to a file you want to read: ");
                        path = in.next();
                        ReadingFromXML rfXML = new ReadingFromXML();
                        rfXML.read(path);
                        System.out.println("Result of reading input.txt is: " + rfXML.result);

                        System.out.println("What would you like to write into output.xml: ");
                        rfXML.write(XMLOutputFileName, in.next());
                    }
                }

                if (key == 2) {
                    while (true) {
                        System.out.println("\nProcessing Zip-archiving...");
                        System.out.println("""
                                What exactly do you need:\s
                                Archive - 1;
                                Dearchive - 2;
                                Get back - 3.""");

                        key = in.nextInt();

                        if (key == 3)
                            break;

                        ZipFiles zf = new ZipFiles();

                        if (key == 1) {
                            System.out.println("Enter path to a file you want to archive: ");
                            path = in.next();
                            zf.archive(path);
                        }

                        if (key == 2) {
                            System.out.println("Enter path to a file you want to unarchive: ");
                            path = in.next();
                            zf.unarchive(path);
                        }
                    }
                }

                if (key == 3) {
                    System.out.println("\nProcessing encryption...");
                    System.out.println("""
                            What exactly do you need:\s
                            Encrypt - 1;
                            Decrypt - 2;
                            Get back - 3.""");

                    key = in.nextInt();

                    if(key == 3)
                        break;

                    if(key == 1) {
                        System.out.println("Enter path to a file you want to encrypt: ");
                        path = in.next();
                        CipherFileEncoder.encryptFile(encKey, new File(path));
                    }

                    if(key == 2) {
                        System.out.println("Enter path to a file you want to decrypt: ");
                        path = in.next();
                        CipherFileEncoder.decryptFile(encKey, new File(path));
                    }
                }
            }
        }
    }
}
