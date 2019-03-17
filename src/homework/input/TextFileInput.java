package homework.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TextFileInput implements Input {

    private File file;

    public TextFileInput(File file) {
        this.file = file;
    }

    @Override
    public List<String> getContent() {

        List<String> contents = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = null;
            while ((line = reader.readLine()) != null) {
                contents.add(line.trim());
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return contents;
    }

}
