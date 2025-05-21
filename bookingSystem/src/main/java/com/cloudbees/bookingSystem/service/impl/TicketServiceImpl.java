package com.cloudbees.bookingSystem.service.impl;

import com.cloudbees.bookingSystem.pojo.Booking;
import com.cloudbees.bookingSystem.repository.TicketRepository;
import com.cloudbees.bookingSystem.repository.impl.TicketRepositoryImpl;
import com.cloudbees.bookingSystem.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(){
        this.ticketRepository=new TicketRepositoryImpl();
    }


    @Override
    public String buyTicket(Booking booking){
        String message = null;
        synchronized(TicketRepositoryImpl.class){
            try{
                if(booking.getFrom()==null || booking.getFrom().trim().length()==0
                        || booking.getTo()==null || booking.getTo().trim().length()==0
                        || booking.getUserEmail()==null || booking.getUserEmail().trim().length()==0){
                    message = "The following fields are mandatory: from, to, user_email_address when booking a ticket";
                }else{
                    if(booking.getPrice()<=0)
                        booking.setPrice(Booking.DEFAULT_TICKET_PRICE);
                    ticketRepository.buyTicket(booking);
                }
            }catch(Exception e){
                e.printStackTrace();
                message = e.getMessage();
            }
        }
        return message;
    }

    @Override
    public Booking getTicket(String emailAddress) {
        return ticketRepository.getTicket(emailAddress);
    }

    @Override
    public List<Booking> getBookings() {
        return ticketRepository.getBookings();
    }

    @Override
    public void removeBooking(String emailAddress){
        Booking booking = ticketRepository.getTicket(emailAddress);
        if(booking!=null)
            ticketRepository.removeBooking(booking);
    }

    @Override
    public void modifyBooking(Booking booking) {
        ticketRepository.modifyBooking(booking);
    }
}
