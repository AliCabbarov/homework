package service.impl;

import model.Word;
import service.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.TreeMap;

public class FileServiceImpl implements FileService {
    private final Path filePath = Paths.get("files\\word.txt");
    private void createDirectoryAndFile() {
        Path directory = Paths.get("files");
        try {
            Files.createDirectory(directory);
            Files.createFile(filePath);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Map<String, String> readFile() {
        try {
            byte[] bytes = Files.readAllBytes(filePath);
            String [] keysAndValues = new String(bytes).split("\n");
            Map<String,String> words = new TreeMap<>();
            for (int i = 0; i < keysAndValues.length; i++) {
                String[] keyAndValue = keysAndValues[i].split(" - ");
                words.put(keyAndValue[0],keyAndValue[1]);
            }
            return words;
        }catch (IOException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public boolean WriteWord(Word word) {
        if (!Files.exists(filePath)) {
            createDirectoryAndFile();
        }
        try {
            Files.writeString(filePath, word.getKeyValue(), StandardOpenOption.APPEND);
            return true;
        } catch (IOException exception) {
            exception.printStackTrace();
            return false;
        }

    }
}
