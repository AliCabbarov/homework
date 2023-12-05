package az.DivAcademy.data;

import az.DivAcademy.model.Courier;
import az.DivAcademy.model.Customer;
import az.DivAcademy.model.Library;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static Library library = new Library("Tech-Library","Azerbaijan/Baku", 556936692,new BigDecimal(0),new ArrayList<>(),new ArrayList<>());
    public static List<Customer> customers = new ArrayList<>();
    public static List<Courier> couriers = new ArrayList<>();
}
