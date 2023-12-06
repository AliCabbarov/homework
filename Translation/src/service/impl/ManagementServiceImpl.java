package service.impl;

import service.GameService;
import service.ManagementService;
import util.MenuUtil;

import java.util.MissingFormatArgumentException;

public class ManagementServiceImpl implements ManagementService {
    @Override
    public void manage() {
        GameService gameService = new GameServiceImpl();
        while (true) {
            try {
                int option = MenuUtil.getInstance().entryMenu();
                switch (option) {
                    case 1:
                        gameService.azerbaijanToEnglish();
                        break;
                    case 2:
                        gameService.englishToAzerbaijan();
                        break;
                    case 3:
                        gameService.showWordList();
                        break;
                    case 4:
                        gameService.showWordsCount();
                        break;
                    case 5:
                        gameService.addWords();
                        break;
                    case 6:
                        System.exit(-1);
                    default:
                        throw new MissingFormatArgumentException("Invalid option!!!");
                }
            }catch (RuntimeException  e){
                e.printStackTrace();
            }
        }
    }
}
