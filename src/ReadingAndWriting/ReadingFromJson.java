package ReadingAndWriting;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadingFromJson {
    String result;

    public ReadingFromJson(){
        result = "";
    }
    public void read(String file_name) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file_name));

        result = new Gson().fromJson(br, String.class);

        br.close();
    }
    public void write(String file_name) throws IOException {

        FileWriter fw = new FileWriter(file_name);

        fw.write(new Gson().toJson(result));

        System.out.println("Succeed, check output.json.");
        fw.close();
    }
}
