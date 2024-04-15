/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class FAQ {

    private int IDFeedback;
    private int IDAccount;
    private int IDBooking;
    private String CustomerName;
    private String TimeFeedback;
    private String Content;
    private String rating;
    private String AdminReply;
    private String ReplyStatus;

    public FAQ(int IDFeedback, int IDAccount, int IDBooking, String CustomerName, String TimeFeedback, String Content, String rating, String AdminReply, String ReplyStatus) {
        this.IDFeedback = IDFeedback;
        this.IDAccount = IDAccount;
        this.IDBooking = IDBooking;
        this.CustomerName = CustomerName;
        this.TimeFeedback = TimeFeedback;
        this.Content = Content;
        this.rating = rating;
        this.AdminReply = AdminReply;
        this.ReplyStatus = ReplyStatus;
    }

    public int getIDFeedback() {
        return IDFeedback;
    }

    public void setIDFeedback(int IDFeedback) {
        this.IDFeedback = IDFeedback;
    }

    public int getIDAccount() {
        return IDAccount;
    }

    public void setIDAccount(int IDAccount) {
        this.IDAccount = IDAccount;
    }

    public int getIDBooking() {
        return IDBooking;
    }

    public void setIDBooking(int IDBooking) {
        this.IDBooking = IDBooking;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getTimeFeedback() {
        return TimeFeedback;
    }

    public void setTimeFeedback(String TimeFeedback) {
        this.TimeFeedback = TimeFeedback;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getAdminReply() {
        return AdminReply;
    }

    public void setAdminReply(String AdminReply) {
        this.AdminReply = AdminReply;
    }

    public String getReplyStatus() {
        return ReplyStatus;
    }

    public void setReplyStatus(String ReplyStatus) {
        this.ReplyStatus = ReplyStatus;
    }

    @Override
    public String toString() {
        return "FAQ{" + "IDFeedback=" + IDFeedback + ", IDAccount=" + IDAccount + ", IDBooking=" + IDBooking + ", CustomerName=" + CustomerName + ", TimeFeedback=" + TimeFeedback + ", Content=" + Content + ", rating=" + rating + ", AdminReply=" + AdminReply + ", ReplyStatus=" + ReplyStatus + '}';
    }
}
