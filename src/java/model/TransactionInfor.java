/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
import java.util.Date;

public class TransactionInfor {
    private int IDTransaction;
    private int IDBooking;
    private int IDPayment;
    private String TransInfo;
    private Date TransTime;
    private String TransStatus;

    public TransactionInfor() {
    }

    public TransactionInfor(int IDTransaction, int IDBooking, int IDPayment, String TransInfo, Date TransTime,
            String TransStatus) {
        this.IDTransaction = IDTransaction;
        this.IDBooking = IDBooking;
        this.IDPayment = IDPayment;
        this.TransInfo = TransInfo;
        this.TransTime = TransTime;
        this.TransStatus = TransStatus;
    }

    public int getIDTransaction() {
        return IDTransaction;
    }

    public void setIDTransaction(int IDTransaction) {
        this.IDTransaction = IDTransaction;
    }

    public int getIDBooking() {
        return IDBooking;
    }

    public void setIDBooking(int IDBooking) {
        this.IDBooking = IDBooking;
    }

    public int getIDPayment() {
        return IDPayment;
    }

    public void setIDPayment(int IDPayment) {
        this.IDPayment = IDPayment;
    }

    public String getTransInfo() {
        return TransInfo;
    }

    public void setTransInfo(String TransInfo) {
        this.TransInfo = TransInfo;
    }

    public Date getTransTime() {
        return TransTime;
    }

    public void setTransTime(Date TransTime) {
        this.TransTime = TransTime;
    }

    public String getTransStatus() {
        return TransStatus;
    }

    public void setTransStatus(String TransStatus) {
        this.TransStatus = TransStatus;
    }

    @Override
    public String toString() {
        return "TransactionInfo{" +
                "IDTransaction=" + IDTransaction +
                ", IDBooking=" + IDBooking +
                ", IDPayment=" + IDPayment +
                ", TransInfo='" + TransInfo + '\'' +
                ", TransTime=" + TransTime +
                ", TransStatus='" + TransStatus + '\'' +
                '}';
    }
}