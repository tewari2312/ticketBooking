package com.cloudbees.bookingSystem.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Booking implements Comparable<Booking>{
    public static final int DEFAULT_TICKET_PRICE = 20;
    private String section;
    private String from;
    private String to;
    private int price;
    private String userEmail;
    private int seatNumber;

    static Map<String, List<Integer>> sectionSeats = new HashMap<>();

    static{
        sectionSeats.put("A", new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10)));
        sectionSeats.put("B", new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10)));
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) throws Exception{
        if(section.equals("A") || section.equals("B"))
            this.section = section;
        else
            throw new Exception("Booking section can only be A or B");
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public static String[] getNextAvailableSeat(){
        String[] nextAvailableSeat = null;
        for(String section : sectionSeats.keySet()){
            if(nextAvailableSeat!=null)
                break;
            if(sectionSeats.get(section).size()>0){
                List<Integer> allSeats = sectionSeats.get(section);
                for (int i = 0; i < allSeats.size(); i++) {
                    if(allSeats.get(i)!=-1){
                        nextAvailableSeat = new String[2];
                        nextAvailableSeat[0] = section;
                        nextAvailableSeat[1] = allSeats.get(i)+"";
                        allSeats.set(i,-1);
                        break;
                    }
                }
            }
        }
        return nextAvailableSeat;
    }

    public static void freeUpSeat(String section, int seatNumber){
        List<Integer> allSeats = sectionSeats.get(section);
        allSeats.set(seatNumber, seatNumber);
    }

    @Override
    public int compareTo(Booking b) {
        if(b.getUserEmail().equals(this.getUserEmail()) && b.getSection().equals(this.getSection()) && b.getSeatNumber()==this.getSeatNumber())
            return 0;
        return 1;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "section='" + section + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
