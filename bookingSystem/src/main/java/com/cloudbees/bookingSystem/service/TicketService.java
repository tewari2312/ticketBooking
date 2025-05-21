package com.cloudbees.bookingSystem.service;

import com.cloudbees.bookingSystem.pojo.Booking;

import java.util.List;

public interface TicketService {

    String buyTicket(Booking booking);

    Booking getTicket(String username);

    List<Booking> getBookings();

    void removeBooking(String userName);

    void modifyBooking(Booking booking);

}
