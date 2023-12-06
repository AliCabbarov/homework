package com.company.helper;

import com.company.data.GlobalData;
import com.company.enums.ExceptionEnum;
import com.company.enums.TitleEnums;
import com.company.exception.ApplicationException;
import com.company.model.Flight;
import com.company.model.Passenger;
import com.company.model.Ticket;
import com.company.util.InputUtil;
import com.company.util.RandomUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

public class HelperService {
    private static long ticketId;
    private static long passengerId;
    private static long flightId;

    public static Flight returnFlight(long id) {
        return GlobalData.flights.stream().
                filter(flight -> flight.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ApplicationException(ExceptionEnum.FLIGHTS_NOT_FOUND_EXCEPTION));
    }

    public static Ticket returnTicket(Flight flight) {
        return new Ticket(++ticketId, RandomUtil.randomNumber(20000000), flight.getSource(), flight.getDestination(), flight.getPrice(), flight.getId());
    }

    public static Passenger returnPassenger(long id) {

            String name = InputUtil.getInstance().inputString("Enter the name: ");
            String surname = InputUtil.getInstance().inputString("Enter the surname: ");
            String phoneNumber = InputUtil.getInstance().inputString("Enter the phoneNumber: ");
            String email = InputUtil.getInstance().inputString("Enter the email: ");
            LocalDate birthdate = dateFormat(TitleEnums.DATE_BIRTHDAY);
            int age = LocalDate.now().minusYears(birthdate.getYear()).getYear();
            String passport = InputUtil.getInstance().inputString("Enter the passport: ");
            String gender = InputUtil.getInstance().inputString("Enter the gender: ");
            return new Passenger(++passengerId, name, surname, age, birthdate, phoneNumber, email, passport, gender, 2000, id, RandomUtil.randomNumber(200));



    }

    private static LocalDate dateFormat(TitleEnums e) {

            String stringDate = InputUtil.getInstance().inputString(e.getMessage() +" (yyyy/MM/dd): ");
            String[] splitString = stringDate.split("/");
            int years = Integer.valueOf(splitString[0]);
            int month = Integer.valueOf(splitString[1]);
            int day = Integer.valueOf(splitString[2]);
            return LocalDate.of(years, month, day);


    }

    public static Flight fillFlight() {

            UUID uuid = UUID.randomUUID();
            String randomName = uuid.toString().substring(0, 5);
            String source = InputUtil.getInstance().inputString("Enter the source: ");
            String destination = InputUtil.getInstance().inputString("Enter the destination: ");
            LocalDate date = dateFormat(TitleEnums.DATE_FLIGHT);
            LocalTime startingTime = LocalTime.now();
            LocalTime reachingTime = LocalTime.now().plusHours(2);
            double price = RandomUtil.randomNumber(2000);
            return new Flight(++flightId, randomName, source, destination, date, startingTime, reachingTime, true, price);

    }

    public static Ticket hasTicket(long id) {
        return GlobalData.tickets.stream()
                .filter(ticket -> ticket.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ApplicationException(ExceptionEnum.TICKETS_NOT_FOUND));
    }

    public static Flight hasFlight(long id) {
        return GlobalData.flights.stream()
                .filter(flight -> flight.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    public static Passenger hasPassenger(long id) {
        return GlobalData.passengers.stream()
                .filter(passenger -> passenger.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    public static void cashReceipt(Flight orderFlight, Ticket orderTicket, Passenger orderPassenger) {
        System.out.println("----------| Cash receipt |--------\n" +
                "\nDate                                         " + orderPassenger.getBirthdate() +
                "\nFlight name                                  " + orderFlight.getName() +
                "\nSeat number                                  " + orderPassenger.getSeatNumber() +
                "\n" +
                "\nPassenger full name                          " + orderPassenger.getName() + " " + orderPassenger.getSurname() +
                "\nPassenger phone number                       " + orderPassenger.getPhoneNumber() +
                "\nPassenger email                              " + orderPassenger.getEmail() +
                "\n" +
                "\nSource                                       " + orderFlight.getSource() +
                "\nDestination                                  " + orderFlight.getDestination() +
                "\nDate                                         " + orderFlight.getDate() +
                "\nStartingTime                                 " + orderFlight.getStartingTime() +
                "\nReachingTime                                 " + orderFlight.getReachingTime());
    }

    public static void checkFlights(){
        if (GlobalData.flights.isEmpty()){
            throw new ApplicationException(ExceptionEnum.FLIGHTS_NOT_FOUND_EXCEPTION);
        }
        GlobalData.flights.stream()
                .filter(flight -> !flight.isContinue())
                .filter(flight -> flight.getDate().getDayOfMonth() < LocalDate.now().getDayOfMonth())
                .peek(flight -> flight.setContinue(false))
                .collect(Collectors.toList());
    }
}
