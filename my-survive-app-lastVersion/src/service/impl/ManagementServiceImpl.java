package service.impl;

import enums.Exception;
import exception.ApplicationException;
import model.Character;
import service.CharacterService;
import service.ManagementService;
import util.MenuUtil;

public class ManagementServiceImpl implements ManagementService {
    @Override
    public void manage() {
        CharacterService characterService = new CharacterServiceImpl(new Character("srtealik"));
        Thread thread = new Thread(characterService);
        thread.start();
        while (true) {
            try {
                int option = MenuUtil.entryMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        characterService.eat();
                        break;
                    case 2:
                        characterService.drink();
                        break;
                    case 3:
                        characterService.show();
                        break;
                    default:
                        throw new ApplicationException(Exception.INVALID_OPTION_EXCEPTION);
                }
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
