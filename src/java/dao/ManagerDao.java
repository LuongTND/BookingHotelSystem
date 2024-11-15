/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbcontext.DBContext;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Booking;
import model.BookingDetails;
import model.Contact;
import model.Discount;
import model.FAQ;
import model.RoomType;
import model.TransactionInfor;
import model.User;

/**
 *
 * @author admin
 */
public class ManagerDao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // ACCOUNT
    // day thong tin all account ra bang quan ly account (View)
    public List<User> getAccounts() {
        List<User> list = new ArrayList<>();
        String query = "select * from Account";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<User> getAccountsFilter() {
        List<User> list = new ArrayList<>();
        String query = "SELECT a.*\n"
                + "FROM Account a\n"
                + "LEFT JOIN BookingDetails bd ON a.IDAccount = bd.IDAccount\n"
                + "WHERE bd.IDAccount IS NULL AND a.IDRole = 1;";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<BookingDetails> getBookingHistoryById(String IDAccount) throws SQLException {
        String query = "select TransactionInfo.IDTransaction, \n"
                + "BookingDetails.FullName, \n"
                + "BookingDetails.Email,\n"
                + "BookingDetails.Phone,\n"
                + "TransactionInfo.TransInfor,\n"
                + "TransactionInfo.TransTime,\n"
                + "BookingDetails.TotalPrice\n"
                + "from BookingDetails inner join TransactionInfo on BookingDetails.IDBooking = TransactionInfo.IDBooking\n"
                + "where BookingDetails.IDAccount = ?;";

        conn = DBContext.getConnection();// mo ket noi
        ps = conn.prepareStatement(query);
        ps.setString(1, IDAccount);
        rs = ps.executeQuery();

        List<BookingDetails> bookings = new ArrayList<>();
        while (rs.next()) {
            BookingDetails booking = new BookingDetails(); // Tạo đối tượng mới cho mỗi hàng
            TransactionInfor transaction = new TransactionInfor(); // Tạo đối tượng mới cho mỗi hàng

            booking.setFullName(rs.getString("FullName"));
            booking.setEmail(rs.getString("Email"));
            booking.setPhone(rs.getString("Phone"));
            booking.setTotalPrice(rs.getDouble("TotalPrice"));

            transaction.setIDTransaction(rs.getInt("IDTransaction"));
            transaction.setTransInfo(rs.getString("TransInfor"));
            transaction.setTransTime(rs.getDate("TransTime"));

            booking.setTransactionInfor(transaction);

            bookings.add(booking);
        }

        // Close the ResultSet, PreparedStatement, and database connection
        rs.close();
        ps.close();
        conn.close();

        // Now you have a list of BookingDetails objects with associated TransactionInfo
        // objects
        // You can further process or display the data as needed
        return bookings;
    }

    // xoa account theo ID (Delete)
    public void deleteAccount(String IDAccount) {
        String query = "delete from Account where IDAccount = ?";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, IDAccount);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    // MANAGER BOOKING
    // day thong tin all Booking ra bang quan ly booking (View)
    public List<Booking> getBooking() {
        List<Booking> list = new ArrayList<>();
        String query = "select * from Booking";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Booking(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getDouble(10),
                        rs.getString(11),
                        rs.getString(12)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    // get list booking
    public List<BookingDetails> getBookingDetails() {
        List<BookingDetails> list = new ArrayList<>();
        String query = "select * from BookingDetails ORDER BY IDBooking DESC;";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new BookingDetails(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getInt(13),
                        rs.getDouble(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<BookingDetails> getBookingDetailsByReceptionist() {
        List<BookingDetails> list = new ArrayList<>();
        String query = "SELECT bd.*\n"
                + "FROM BookingDetails bd\n"
                + "JOIN Account a ON bd.IDAccount = a.IDAccount\n"
                + "WHERE a.IDRole = 2 or a.IDRole =3 ORDER BY bd.IDBooking DESC;";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new BookingDetails(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getInt(13),
                        rs.getDouble(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<BookingDetails> getBookingDetailsByCustomer() {
        List<BookingDetails> list = new ArrayList<>();
        String query = "SELECT bd.*\n"
                + "FROM BookingDetails bd\n"
                + "JOIN Account a ON bd.IDAccount = a.IDAccount\n"
                + "WHERE a.IDRole = 1 ORDER BY bd.IDBooking DESC;";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new BookingDetails(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getInt(13),
                        rs.getDouble(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<BookingDetails> searchBookingDetails(String Phone) {
        List<BookingDetails> list = new ArrayList<>();
        String query = "SELECT bd.*\n"
                + "FROM BookingDetails bd\n"
                + "INNER JOIN TransactionInfo p ON bd.IDBooking = p.IDBooking\n"
                + "WHERE p.IDTransaction = ?;";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, Phone);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new BookingDetails(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getInt(13),
                        rs.getDouble(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void updateBookingStatus(String IDBooking, String BookingStatus) {
        String query = "update BookingDetails set Note = ? where IDBooking = ?";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);

            ps.setString(1, BookingStatus);
            ps.setString(2, IDBooking);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    // xoa account theo ID (Delete)
    public void deleteBooking(String IDBooking) {
        String query = "delete from Booking where IDBooking = ?";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, IDBooking);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    // MANAGER ROOMTYPE
    public List<RoomType> getRoomType() {
        List<RoomType> list = new ArrayList<>();
        String query = "select * from RoomType";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new RoomType(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void addRoomType(String NameRoomType, String MaxPerson, String NumberOfBed, String NumberOfBath,
            String Price, String TotalRoom, String RoomStatus, String Content) {
        String query = "insert into RoomType(NameRoomType,MaxPerson,NumberOfBed,NumberOfBath,Price, TotalRoom,RoomStatus,Content) values (?,?,?,?,?,?,?,?)";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, NameRoomType);
            ps.setString(2, MaxPerson);
            ps.setString(3, NumberOfBed);
            ps.setString(4, NumberOfBath);
            ps.setString(5, Price);
            ps.setString(6, TotalRoom);
            ps.setString(7, RoomStatus);
            ps.setString(8, Content);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public RoomType getRoomTypeById(String IDRoomType) {
        String query = "select * from RoomType where IDRoomType=?";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, IDRoomType);
            rs = ps.executeQuery();
            while (rs.next()) {
                return (new RoomType(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (Exception e) {
        }
        return null;
    }

    // xoa RoomType theo ID (Delete)
    public void deleteRoomType(String IDRoomType) {
        String query = "delete from RoomType where IDRoomType = ?";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, IDRoomType);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    // chinh sua thong tin RoomType (Update)
    public void updateRoomType(String IDRoomType, String NameRoomType, String MaxPerson, String NumberOfBed,
            String NumberOfBath, String Price, String totalRoom, String RoomStatus, String Content) {
        String query = "update RoomType set NameRoomType=?, MaxPerson=?, NumberOfBed=?, NumberOfBath=?,Price=?, TotalRoom=? ,RoomStatus=?, Content=? where IDRoomType = ?";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, NameRoomType);
            ps.setString(2, MaxPerson);
            ps.setString(3, NumberOfBed);
            ps.setString(4, NumberOfBath);
            ps.setString(5, Price);
            ps.setString(6, totalRoom);
            ps.setString(7, RoomStatus);
            ps.setString(8, Content);
            ps.setString(9, IDRoomType);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateTotalRoomType(String IDRoomType, String totalRoom, String RoomStatus) {
        String query = "update RoomType set TotalRoom=? ,RoomStatus=? where IDRoomType = ?";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, totalRoom);
            ps.setString(2, RoomStatus);
            ps.setString(3, IDRoomType);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    // MANAGER DISCOUNT
    public List<Discount> getDiscount() {
        List<Discount> list = new ArrayList<>();
        String query = "select * from Discount";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Discount(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Discount getDiscountById(String IDDiscount) {
        String query = "select * from Discount where IDDiscount=?";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, IDDiscount);
            rs = ps.executeQuery();
            while (rs.next()) {
                return (new Discount(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void addDiscount(String DiscountName, String DiscountValue, String StartDay, String EndDay, String Note) {
        String query = "insert into Discount(DiscountName,DiscountValue,StartDay,EndDay,Note) values (?,?,?,?,?)";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, DiscountName);
            ps.setString(2, DiscountValue);
            ps.setString(3, StartDay);
            ps.setString(4, EndDay);
            ps.setString(5, Note);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    // xoa Discount theo ID (Delete)
    public void deleteDiscount(String IDDiscount) {
        String query = "delete from Discount where IDDiscount = ?";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, IDDiscount);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    // chinh sua thong tin Discount (Update)
    public void updateDiscount(String IDDiscount, String DiscountName, String DiscountValue, String StartDay,
            String EndDay, String Note) {
        String query = "update Discount set DiscountName=?, DiscountValue=?, StartDay=?, EndDay=?, Note=? where IDDiscount = ?";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, DiscountName);
            ps.setString(2, DiscountValue);
            ps.setString(3, StartDay);
            ps.setString(4, EndDay);
            ps.setString(5, Note);
            ps.setString(6, IDDiscount);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Booking getBookingById(String IDBooking) {
        String query = "select * from Booking where IDBooking=?";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, IDBooking);
            rs = ps.executeQuery();
            while (rs.next()) {
                return (new Booking(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getDouble(10),
                        rs.getString(11),
                        rs.getString(12)));
            }
        } catch (Exception e) {
        }
        return null;
    }

    // CONTACT
    public List<Contact> getContact() {
        List<Contact> list = new ArrayList<>();
        String query = "select * from Contact ct ORDER BY ct.IDContact DESC;";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Contact(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void updateContact(String IDContact, String ContactStatus) {
        String query = "update Contact set ContactStatus = ? where IDContact = ?";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);

            ps.setString(1, ContactStatus);
            ps.setString(2, IDContact);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateReplyFeedback(String IDFeeddback, String AdminReply, String ReplyStatus) {
        String query = "update Feedback set AdminReply = ?, ReplyStatus =? where IDFeedback = ?";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);

            ps.setString(1, AdminReply);
            ps.setString(2, ReplyStatus);
            ps.setString(3, IDFeeddback);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<FAQ> getFeedbacksAdmin() {
        List<FAQ> list = new ArrayList<>();
        String query = "select top 5 * from Feedback where ReplyStatus= 'NotYet' ORDER BY IDFeedback DESC;";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new FAQ(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<FAQ> getFeedbacksSearch(String s) {
        List<FAQ> list = new ArrayList<>();
        String query = "select * from Feedback where CustomerName like ? ORDER BY IDFeedback DESC";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + s + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new FAQ(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<FAQ> getFeedbacksFilter(String f) {
        List<FAQ> list = new ArrayList<>();
        String query = "select * from Feedback where Rating = ? ORDER BY IDFeedback DESC";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, f);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new FAQ(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
