package service.impl;

import model.Character;
import service.CharacterService;
import service.ManagementService;
import util.MenuUtil;

public class ManagementServiceImpl implements ManagementService {
    @Override
    public void management() {
        CharacterService characterService =
                new CharacterServiceImpl(new Character("Alex"));

        Thread thread = new Thread(characterService);
        thread.start();

        while (true) {
            int option = MenuUtil.menuEntry();

            switch (option) {
                case 1:
                    characterService.eat();
                    break;
                case 2:
                    characterService.drink();
                    break;
                case 3:
                    characterService.showHealthy();
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }

    }
}
