package com.cloudbees.bookingSystem.controller;

import com.cloudbees.bookingSystem.pojo.Booking;
import com.cloudbees.bookingSystem.service.TicketService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    private final TicketService ticketService;
    @Autowired
    public BookingController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/purchaseTicket")
    public String purchaseTicket(@RequestBody Booking booking) {
        String message = ticketService.buyTicket(booking);
        if(message==null)
            message = "purchase successful. you can get your ticket details using your email address.";
        return message;
    }

    @GetMapping("/getTicketDetails")
    public Booking getTicket(@RequestParam String emailAddress) {
        return ticketService.getTicket(emailAddress);
    }

    @GetMapping("/getAllTickets")
    public List<Booking> getAllTickets() {
        return ticketService.getBookings();
    }

    @DeleteMapping("/removeTicket")
    public void removeTicket(@RequestParam String emailAddress) {
        ticketService.removeBooking(emailAddress);
    }

    @PutMapping("/modifyTicket")
    public void modifyBooking(@RequestBody Booking booking) {
        ticketService.modifyBooking(booking);
    }

    @PostConstruct
    public void init() {
        System.out.println("BookingController initialized!");
    }
}
