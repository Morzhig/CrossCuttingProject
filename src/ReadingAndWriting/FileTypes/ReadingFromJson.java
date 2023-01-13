package ReadingAndWriting.FileTypes;

import ReadingAndWriting.Interfaces.ReadingAndWriting;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadingFromJson implements ReadingAndWriting {
    public String result = "";

    @Override
    public void read(String file_name) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file_name));

        result = new Gson().fromJson(br, String.class);

        br.close();
    }

    @Override
    public void write(String file_name, String text) throws IOException {

        FileWriter fw = new FileWriter(file_name);

        fw.write(new Gson().toJson(text));

        fw.close();
    }
}
