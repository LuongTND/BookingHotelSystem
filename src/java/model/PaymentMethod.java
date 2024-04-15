/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class PaymentMethod {
    private int IDPayment;
    private String NamePaymentMethod;

    public PaymentMethod() {
    }

    public PaymentMethod(String NamePaymentMethod) {
        this.NamePaymentMethod = NamePaymentMethod;
    }

    public int getIDPayment() {
        return IDPayment;
    }

    public void setIDPayment(int IDPayment) {
        this.IDPayment = IDPayment;
    }

    public String getNamePaymentMethod() {
        return NamePaymentMethod;
    }

    public void setNamePaymentMethod(String NamePaymentMethod) {
        this.NamePaymentMethod = NamePaymentMethod;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "IDPayment=" + IDPayment +
                ", NamePaymentMethod='" + NamePaymentMethod + '\'' +
                '}';
    }
}