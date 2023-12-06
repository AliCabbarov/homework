package com.company.service.impl;

import com.company.data.GlobalData;
import com.company.enums.ExceptionEnum;
import com.company.exception.ApplicationException;
import com.company.helper.HelperService;
import com.company.model.Flight;
import com.company.model.Passenger;
import com.company.model.Ticket;
import com.company.service.AdminService;
import com.company.service.CustomerService;
import com.company.util.InputUtil;
import com.company.util.MenuUtil;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public void viewFlights() {

        if (GlobalData.flights.isEmpty()) {
            throw new ApplicationException(ExceptionEnum.FLIGHTS_NOT_FOUND_EXCEPTION);
        }
        GlobalData.flights.stream()
                .filter(Flight::isContinue)
                .forEach(System.out::println);

    }

    @Override
    public void OrderTicket() {
        byte option = MenuUtil.getInstance().orderMenu();
        switch (option) {
            case 1:
                GlobalData.flights.stream()
                        .filter(Flight::isContinue)
                        .forEach(System.out::println);

                long id = InputUtil.getInstance().inputLong("Choose the flight id: ");

                Flight flight = HelperService.returnFlight(id);

                Ticket ticket = HelperService.returnTicket(flight);

                Passenger passenger = HelperService.returnPassenger(ticket.getId());

                GlobalData.tickets.add(ticket);
                GlobalData.passengers.add(passenger);

                GlobalData.airport.incrementTotalAmount(flight.getPrice());
                passenger.setBalance(passenger.getBalance() - flight.getPrice());

                HelperService.cashReceipt(flight, ticket, passenger);

                break;
            case 2:


                Flight orderFlight = HelperService.fillFlight();

                Ticket orderTicket = HelperService.returnTicket(orderFlight);

                Passenger orderPassenger = HelperService.returnPassenger(orderTicket.getId());

                GlobalData.flights.add(orderFlight);
                GlobalData.tickets.add(orderTicket);
                GlobalData.passengers.add(orderPassenger);

                GlobalData.airport.incrementTotalAmount(orderFlight.getPrice());
                orderPassenger.setBalance(orderPassenger.getBalance() - orderFlight.getPrice());

                HelperService.cashReceipt(orderFlight, orderTicket, orderPassenger);

                break;
            default:
                throw new ApplicationException(ExceptionEnum.INVALID_OPTION_EXCEPTION);

        }

    }

    @Override
    public void cancelTickets() {
        AdminService adminService = new AdminServiceImpl();
        adminService.viewTickets();
        long cancelId = InputUtil.getInstance().inputLong("Enter the cancel id: ");
        Ticket ticket = HelperService.hasTicket(cancelId);
        Flight flight = HelperService.hasFlight(ticket.getId());
        Passenger passenger = HelperService.hasPassenger(ticket.getId());
        GlobalData.airport.decrementTotalAmount(flight.getPrice());
        passenger.setBalance(passenger.getBalance() + flight.getPrice());
        System.out.println("Canceled Successfully");

    }
}
