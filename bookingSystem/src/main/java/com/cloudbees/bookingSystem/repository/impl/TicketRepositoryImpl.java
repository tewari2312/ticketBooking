package com.cloudbees.bookingSystem.repository.impl;

import com.cloudbees.bookingSystem.pojo.Booking;
import com.cloudbees.bookingSystem.repository.TicketRepository;

import java.util.ArrayList;
import java.util.List;

public class TicketRepositoryImpl implements TicketRepository {

    static List<Booking> allBookings = new ArrayList<>();

    @Override
    public void buyTicket(Booking booking) throws Exception{
        String[] nextSeat = Booking.getNextAvailableSeat();
        if(nextSeat==null)
            throw new Exception("All seats in all sections are filled");
        booking.setSection(nextSeat[0]);
        booking.setSeatNumber(Integer.parseInt(nextSeat[1]));
        allBookings.add(booking);
    }

    @Override
    public Booking getTicket(String emailAddress) {
        for (Booking booking : allBookings){
            if(booking.getUserEmail().equalsIgnoreCase(emailAddress))
                return booking;
        }
        return null;
    }

    @Override
    public List<Booking> getBookings() {
        return allBookings;
    }

    @Override
    public void removeBooking(Booking bookingToRemove) {
        Booking.freeUpSeat(bookingToRemove.getSection(), bookingToRemove.getSeatNumber());
        allBookings.remove(bookingToRemove);
    }

    @Override
    public Booking modifyBooking(Booking updatedBooking) {
        for (Booking booking : allBookings){
            if(booking.equals(updatedBooking)){
                allBookings.remove(booking);
                allBookings.add(updatedBooking);
            }
        }
        return updatedBooking;
    }
}
