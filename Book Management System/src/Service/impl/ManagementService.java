package Service.impl;

import Service.impl.BookService;
import Util.MenuUtil;

public class ManagementService {
    public static void bookManage(){
        BookService bookService = new BookService();
        while (true){
            int option = MenuUtil.entryMenu();
            switch (option){
                case 1:
                    bookService.display();
                    break;
                case 2:
                    bookService.search();
                    break;
                case 3:
                    bookService.add();
                    break;
                case 4:
                    bookService.update();
                    break;
                case 5:
                    bookService.remove();
                    break;
                case 0:
                    System.out.println("-------------------\n" +
                            "Bye\n" +
                            "-----------------------");
                    System.exit(-1);
                    break;
                default:
                    System.out.println("invalid option!!!");
            }
        }
    }

}
