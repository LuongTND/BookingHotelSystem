/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Booking {

    private int IDBooking;
    private int IDAccount;
    private int IDDiscount;
    private int IDRoomType;
    
//    private String FullName;
//    private String Gender;
//    private String Email;
//    private String Phone;
    
    private int Adult;
    private int Child;
    private String CheckIn;
    private String CheckOut;
    private int NumberOfRooms;
    private double TotalPrice;
    private String BookingTime;
    private String Note;
    
    

    public Booking(int IDBooking, int IDAccount, int IDDiscount, int IDRoomType, int Adult, int Child, String CheckIn, String CheckOut, int NumberOfRooms, double TotalPrice, String BookingTime, String Note) {
        this.IDBooking = IDBooking;
        this.IDAccount = IDAccount;
        this.IDDiscount = IDDiscount;
        this.IDRoomType = IDRoomType;
        this.Adult = Adult;
        this.Child = Child;
        this.CheckIn = CheckIn;
        this.CheckOut = CheckOut;
        this.NumberOfRooms = NumberOfRooms;
        this.TotalPrice = TotalPrice;
        this.BookingTime = BookingTime;
        this.Note = Note;
    }

    public int getIDBooking() {
        return IDBooking;
    }

    public void setIDBooking(int IDBooking) {
        this.IDBooking = IDBooking;
    }

    public int getIDAccount() {
        return IDAccount;
    }

    public void setIDAccount(int IDCustomer) {
        this.IDAccount = IDCustomer;
    }

    public int getIDDiscount() {
        return IDDiscount;
    }

    public void setIDDiscount(int IDDiscount) {
        this.IDDiscount = IDDiscount;
    }

    public int getIDRoomType() {
        return IDRoomType;
    }

    public void setIDRoomType(int IDRoomType) {
        this.IDRoomType = IDRoomType;
    }

    public int getAdult() {
        return Adult;
    }

    public void setAdult(int Adult) {
        this.Adult = Adult;
    }

    public int getChild() {
        return Child;
    }

    public void setChild(int Child) {
        this.Child = Child;
    }

    public String getCheckIn() {
        return CheckIn;
    }

    public void setCheckIn(String CheckIn) {
        this.CheckIn = CheckIn;
    }

    public String getCheckOut() {
        return CheckOut;
    }

    public void setCheckOut(String CheckOut) {
        this.CheckOut = CheckOut;
    }

    public int getNumberOfRooms() {
        return NumberOfRooms;
    }

    public void setNumberOfRooms(int NumberOfRooms) {
        this.NumberOfRooms = NumberOfRooms;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public String getBookingTime() {
        return BookingTime;
    }

    public void setBookingTime(String BookingTime) {
        this.BookingTime = BookingTime;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    @Override
    public String toString() {
        return "Booking{" + "IDBooking=" + IDBooking + ", IDAccount=" + IDAccount + ", IDDiscount=" + IDDiscount + ", IDRoomType=" + IDRoomType + ", Adult=" + Adult + ", Child=" + Child + ", CheckIn=" + CheckIn + ", CheckOut=" + CheckOut + ", NumberOfRooms=" + NumberOfRooms + ", TotalPrice=" + TotalPrice + ", BookingTime=" + BookingTime + ", Note=" + Note + '}';
    }

}
