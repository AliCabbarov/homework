package service.impl;

import data.GlobalData;
import enums.Status;
import model.User;
import service.UserService;
import util.InputUtil;

import java.time.LocalDate;

import static helperService.HelperService.*;
import static util.InputUtil.getInstance;
import static util.InputUtil.instance;

public class UserServiceImpl implements UserService {

    @Override
    public void register() {
        int count = instance.inputInt("How many register: ");
        if (GlobalData.users == null) {
            GlobalData.users = new User[count];
            System.out.println("---------------| Register member |---------------");
            for (int i = 0; i < GlobalData.users.length; i++) {
                boolean isTrue = appropriationCustomer();
                if (isTrue) {
                    System.out.println(Status.REGISTER_SUCCESSFULLY);
                }
            }
        } else {
            User[] tempuUser = GlobalData.users;
            GlobalData.users = new User[GlobalData.users.length + count];
            System.out.println("---------------| Register member |---------------");
            for (int i = 0; i < GlobalData.users.length; i++) {
                if (i < tempuUser.length) {
                    GlobalData.users[i] = tempuUser[i];
                } else {
                    boolean isTrue = appropriationCustomer();
                    if (isTrue) {
                        System.out.println(Status.REGISTER_SUCCESSFULLY);
                    }
                }

            }
        }
        deleteNullCustomer();
    }

    @Override
    public void Show() {
        nullGlobalDataException();
        System.out.println("---------------| All members |--------------- ");
        for (User user : GlobalData.users) {
            System.out.println(user.toString());
        }
    }

    @Override
    public void enterGym() {
        nullGlobalDataException();
        System.out.println("------| Enter the gym |------");
        String fin = getInstance().inputString("Enter the fin code");
        for (User user : GlobalData.users) {
            if (user.getFin().equals(fin)) {
                if (user.getDepartures() > 0) {
                    user.setDepartures(user.getDepartures() - 1);
                    System.out.println("--" + user.getSurname() + " " + user.getName() + "-" + user.getDepartures() + " left---");
                } else System.out.println("----rejected----");

            }
        }

    }
    @Override
    public void UpdateDepartures() {
        nullGlobalDataException();
        System.out.println("------| Update departures |------");
        String fin = getInstance().inputString("Enter the fin code");
        for (User user : GlobalData.users) {
            if (user.getFin().equals(fin)) {
                int departures = InputUtil.getInstance().inputInt("Add  number of departures: ");
                LocalDate updateDate = dateFormat("Enter the update date: ");
                LocalDate updateExpirationDate = dateFormat("Enter the membership expiration date: ");
                user.setUpdateDate(updateDate);
                user.setExpirationDate(updateExpirationDate);
                user.setDepartures(user.getDepartures() + departures);
                System.out.println(user.getSurname() + " " + user.getName() + " – Departure updated successfully!");
            }
        }
    }
}
