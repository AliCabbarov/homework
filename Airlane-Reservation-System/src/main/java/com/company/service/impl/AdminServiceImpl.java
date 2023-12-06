package com.company.service.impl;

import com.company.data.GlobalData;
import com.company.enums.ExceptionEnum;
import com.company.exception.ApplicationException;
import com.company.helper.HelperService;
import com.company.model.Flight;
import com.company.service.AdminService;
import com.company.util.InputUtil;

import java.time.Duration;
import java.time.LocalDate;

public class AdminServiceImpl implements AdminService {
    @Override
    public void addFlight() {
        Flight flight = HelperService.fillFlight();
        GlobalData.flights.add(flight);
    }

    @Override
    public void viewTickets() {
        if (GlobalData.tickets.isEmpty()) {
            throw new ApplicationException(ExceptionEnum.TICKETS_NOT_FOUND);
        }
        GlobalData.tickets.stream()
                .forEach(System.out::println);
    }

    @Override
    public void viewPassenger() {
        if (GlobalData.passengers.isEmpty()) {
            throw new ApplicationException(ExceptionEnum.PASSENGER_NOT_FOUND);
        }
        GlobalData.passengers
                .forEach(System.out::println);

    }

    @Override
    public void viewNoticeBoard() {
        if (GlobalData.flights.isEmpty()) {
            throw new ApplicationException(ExceptionEnum.FLIGHTS_NOT_FOUND_EXCEPTION);
        }
        GlobalData.flights.stream()
                .filter(flight -> Duration.between(flight.getDate(), LocalDate.now()).toHours() < 24)
                .forEach(System.out::println);
    }

    @Override
    public void viewFlight() {
        if (GlobalData.flights.isEmpty()) {
            throw new ApplicationException(ExceptionEnum.FLIGHTS_NOT_FOUND_EXCEPTION);
        }
        GlobalData.flights
                .stream().filter(Flight::isContinue)
                .forEach(System.out::println);
    }

    @Override
    public void searchAll() {
        if (GlobalData.flights.isEmpty()) {
            throw new ApplicationException(ExceptionEnum.FLIGHTS_NOT_FOUND_EXCEPTION);
        }
        long id = InputUtil.getInstance().inputLong("Enter the flight id: ");
        GlobalData.flights.stream()
                .filter(flight -> flight.getId() == id)
                .forEach(System.out::println);
    }
}
