package ReadingAndWriting;

import java.util.Scanner;
import java.io.*;
public class ReadingFromTxt {
    String result;

    public ReadingFromTxt(){
        result="";
    }

    public void read(String file_name) throws IOException {
        FileReader fr = new FileReader(file_name);
        Scanner in = new Scanner(fr);

        while(in.hasNextLine()){
            result = result.concat(in.nextLine());
            result = result.concat("\n");
        }

        in.close();
    }

    public void write(String file_name) throws IOException {
        FileWriter fw = new FileWriter(file_name);

        fw.write(result);

        System.out.println("Succeed, check output.txt.");
        fw.close();
    }
}
