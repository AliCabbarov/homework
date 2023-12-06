package service.impl;

import helperService.GameHelperService;
import model.Word;
import service.FileService;
import service.GameService;
import util.InputUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameServiceImpl implements GameService {
    FileService fileService;

    public GameServiceImpl() {
        fileService = new FileServiceImpl();
    }

    @Override
    public void azerbaijanToEnglish() {
        Map<String, String> keyAndValues = fileService.readFile();
        int countWord = InputUtil.getInstance().inputInt("Enter the word count: ");
        if (countWord < 5) {
            countWord = 5;
        }
        if (countWord > keyAndValues.size()) {
            countWord = keyAndValues.size();
        }
        double trueAnswer = 0;
        double wrongAnswer = 0;
        List<String> values = new ArrayList<>();
        List<String> keys = new ArrayList<>();
        for (Map.Entry<String,String> valueAndKey : fileService.readFile().entrySet()) {
            values.add(valueAndKey.getValue());
            keys.add(valueAndKey.getKey());
        }
        for (int i = 0; i < countWord; i++) {
            String[] randomKeyAndValue = GameHelperService.getInstance().randomKeyAndValue(keys,values, values.size());
            String inputValue = InputUtil.getInstance().inputString(randomKeyAndValue[0] + " - ");
            if (inputValue.equals(randomKeyAndValue[1])) {
                trueAnswer++;
            } else {
                System.out.println("True answer: " + randomKeyAndValue[1]);
                wrongAnswer++;
            }
            keys.remove(Integer.parseInt(randomKeyAndValue[2]));
            values.remove(Integer.parseInt(randomKeyAndValue[2]));
        }
        GameHelperService.getInstance().result(wrongAnswer,trueAnswer);
    }

    @Override
    public void englishToAzerbaijan() {
        Map<String, String> keyAndValues = fileService.readFile();
        int countWord = InputUtil.getInstance().inputInt("Enter the word count: ");
        if (countWord < 5) {
            countWord = 5;
        }
        if (countWord > keyAndValues.size()) {
            countWord = keyAndValues.size();
        }
        double trueAnswer = 0;
        double wrongAnswer = 0;
        List<String> values = new ArrayList<>();
        List<String> keys = new ArrayList<>();
        for (Map.Entry<String,String> valueAndKey : fileService.readFile().entrySet()) {
            values.add(valueAndKey.getValue());
            keys.add(valueAndKey.getKey());
        }
        for (int i = 0; i < countWord; i++) {
            String[] randomKeyAndValue = GameHelperService.getInstance().randomKeyAndValue(keys,values, values.size());
            String inputKey = InputUtil.getInstance().inputString(randomKeyAndValue[1] + " - ");
            if (inputKey.equals(randomKeyAndValue[0])) {
                trueAnswer++;
            } else {
                System.out.println("True answer: " + randomKeyAndValue[0]);
                wrongAnswer++;
            }
            keys.remove(Integer.parseInt(randomKeyAndValue[2]));
            values.remove(Integer.parseInt(randomKeyAndValue[2]));
        }
        GameHelperService.getInstance().result(wrongAnswer,trueAnswer);

    }

    @Override
    public void showWordList() {
        if (fileService.readFile().isEmpty()) {
            throw new NullPointerException();
        }
        int i = 1;
        for (Map.Entry<String, String> words : fileService.readFile().entrySet()) {
            System.out.println(i++ + ". " + words.getKey() + " - " + words.getValue());
        }
    }

    @Override
    public void showWordsCount() {
        if (fileService.readFile().isEmpty()) {
            throw new NullPointerException();
        }
        System.out.println("Words count: " + fileService.readFile().size());
    }

    @Override
    public void addWords() {
        String key = InputUtil.getInstance().inputString("Enter the key: ");
        String value = InputUtil.getInstance().inputString("Enter the value: ");
        boolean isAdd = fileService.WriteWord(new Word(key, value));
        System.out.println(isAdd ? "Successfully!" : "Failed!");
    }
}
