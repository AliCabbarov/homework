package service.impl;

import model.Word;
import service.FileService;
import service.GameService;
import util.InputUtil;
import util.RandomUtil;

public class GameServiceImpl implements GameService {
    FileService fileService;
    public GameServiceImpl() {
        fileService = new FileServiceImpl();
    }

    @Override
    public void play() {
        Word[] words = fileService.readFile();
        int point = 0;
        for (int i = 0; i < 10; i++) {
            int randomIndex = RandomUtil.getInstance().getRandomIndex(words.length);
            if (words[randomIndex].isShowed()) {
                i--;
                words[randomIndex].setShowed(true);
                continue;
            }
            if (isAnswerTrue(words[randomIndex])){
                point++;
                words[randomIndex].setShowed(true);
            }
        }
        System.out.println("your point: " + point);

    }

    @Override
    public void show() {
        Word[] words = fileService.readFile();
        System.out.println("---------| Words |----------");
        for (Word word : words) {
            System.out.print(word.getKeyValue());
        }
        System.out.println("-----------------------------");
    }

    @Override
    public void add() {
        String key = InputUtil.getInstance().inputString("Eng: ");
        String value = InputUtil.getInstance().inputString("Az: ");
        boolean isAdd = fileService.writeFile(new Word(key, value));
        System.out.println(isAdd ? "Successfully" : "Failed!");

    }

    private String playerAnswer(Word word) {
        return InputUtil.getInstance().inputString(word.getKey() + ": ");
    }
    private boolean isAnswerTrue(Word word){
        return playerAnswer(word).equals(word.getValue());
    }
}
