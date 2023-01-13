package ReadingAndWriting.FileTypes;

import ReadingAndWriting.Interfaces.ReadingAndWriting;

import java.util.Scanner;
import java.io.*;
public class ReadingFromTxt implements ReadingAndWriting {
    public String result = "";

    @Override
    public void read(String file_name) throws IOException {
        FileReader fr = new FileReader(file_name);
        Scanner in = new Scanner(fr);

        while(in.hasNextLine())
            result = result.concat(in.nextLine());

        in.close();
    }

    @Override
    public void write(String file_name, String text) throws IOException {
        FileWriter fw = new FileWriter(file_name);

        fw.write(text);

        fw.close();
    }
}
