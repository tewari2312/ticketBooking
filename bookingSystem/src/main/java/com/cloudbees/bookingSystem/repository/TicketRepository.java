package com.cloudbees.bookingSystem.repository;

import com.cloudbees.bookingSystem.pojo.Booking;

import java.util.List;

public interface TicketRepository {

    void buyTicket(Booking booking) throws Exception;

    Booking getTicket(String username);

    List<Booking> getBookings();

    void removeBooking(Booking booking);

    Booking modifyBooking(Booking booking);

}
