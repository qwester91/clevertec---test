package by.harashchenia.service.converter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FromFileToMapArgs {

    public Map<String,String> readFromFile(String path){
        String file;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            file = reader.readLine();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }String[] args = file.split(" ");
        Map<String,String> fromFileArgs = new HashMap<>();
        for (String arg : args) {
            String[] split = arg.split("-");
            fromFileArgs.put(split[0], split[1]);
        }


        return fromFileArgs;
    }
}
