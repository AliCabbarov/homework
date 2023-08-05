package service;

import model.Word;

public interface FileService {
    Word[] readFile();
    boolean writeFile(Word word);
}
