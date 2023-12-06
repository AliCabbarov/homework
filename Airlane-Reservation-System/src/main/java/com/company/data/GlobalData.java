package com.company.data;

import com.company.model.Airport;
import com.company.model.Flight;
import com.company.model.Passenger;
import com.company.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static Airport airport = new Airport(1,"Heydar Aliyev","Baku",0);
    public static List<Flight> flights = new ArrayList<>();
    public static List<Passenger> passengers = new ArrayList<>();
    public static List<Ticket> tickets = new ArrayList<>();
}
