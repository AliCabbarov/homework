package service;

import model.Word;

import java.util.Map;

public interface FileService {
    Map<String,String> readFile();
    boolean WriteWord(Word word);
}
