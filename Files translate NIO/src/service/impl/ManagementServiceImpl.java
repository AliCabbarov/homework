package service.impl;

import service.GameService;
import service.ManagementService;
import util.MenuUtil;

public class ManagementServiceImpl implements ManagementService {
    private GameService gameService;

    public ManagementServiceImpl() {
        gameService = new GameServiceImpl();
    }

    @Override
    public void manage() {
        while (true) {
            try {


                int option = MenuUtil.getInstance().entryMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        gameService.play();
                        break;
                    case 2:
                        gameService.show();
                        break;
                    case 3:
                        gameService.add();
                        break;
                    default:
                        System.err.println("invalid option!!!");
                }
            }catch (Throwable throwable){
                throwable.printStackTrace();
            }
        }

    }
}
