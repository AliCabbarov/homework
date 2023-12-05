package az.DivAcademy.helper;

import az.DivAcademy.data.GlobalData;
import az.DivAcademy.enums.ExceptionEnum;
import az.DivAcademy.exception.ApplicationException;
import az.DivAcademy.model.Book;
import az.DivAcademy.model.Customer;
import az.DivAcademy.util.InputUtil;

import java.util.ArrayList;

public class BookHelperService {
    private static long bookId = 0;
    public static Book fillBook(){
        try {
            String title = InputUtil.getInstance().inputString("Enter the book title: ");
            String author = InputUtil.getInstance().inputString("Enter the author name: ");
            String genre = InputUtil.getInstance().inputString("Enter the genre: ");
            int copiesCount = InputUtil.getInstance().inputInt("enter the copies count: ");
            double price = InputUtil.getInstance().inputDouble("Enter the book price: ");
            return new Book(++bookId,title,author,genre,copiesCount,new ArrayList<>(),0,0,price);
        }catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void showBook(Customer customer) {
        customer.getOrders()
                .forEach(order -> System.out.println(order.getBook()));
    }

    public static Book chooseBook(Customer customer) {
        long bookId = InputUtil.getInstance().inputLong("Choose the book : ");
        return customer.getOrders().stream()
                .filter(order -> order.getBook().getId() == bookId)
                .findFirst()
                .orElseThrow(() -> new ApplicationException(ExceptionEnum.BOOK_NOT_FOUND_EXCEPTION))
                .getBook();
    }


}
