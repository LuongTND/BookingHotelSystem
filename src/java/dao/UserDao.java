/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbcontext.DBContext;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.BookingDetails;
import model.CheckRoomValid;
import model.Contact;
import model.Discount;
import model.FAQ;
import model.User;

/**
 *
 * @author admin
 */
public class UserDao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // login
    public User checkAccountValid(String user, String pass) {
        String query = "select *from Account where UserName = ? and Pass =?";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public User checkAccountExist(String user) {
        String query = "select * from Account where UserName = ?";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void addTransaction(String IDTransaction, String IDPayment, String TransInfo, String TransTime,
            String TransStatus) {
        String query = "insert into TransactionInfo(IDTransaction,IDPayment,TransInfor,TransTime,TransStatus) values(?,?,?,?,?)";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, IDTransaction);
            ps.setString(2, IDPayment);
            ps.setString(3, TransInfo);
            ps.setString(4, TransTime);
            ps.setString(5, TransStatus);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public User checkEmailExist(String email) {
        String query = "select * from Account where Email = ?";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public User getAccountByEmail(String email) {
        User acc = new User();
        String sql = "select * from Account where Email =?";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                acc.setIDAccount(rs.getInt(1));
                acc.setUserName(rs.getString(2));
                acc.setPass(rs.getString(3));
                acc.setFullName(rs.getString(4));
                acc.setGender(rs.getString(5));
                acc.setCity(rs.getString(6));
                acc.setEmail(rs.getString(7));

                acc.setPhone(rs.getString(8));

                acc.setIDRole(rs.getInt(9));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return acc;
    }

    public void addAccountLoginWithGoogle(User acc) {
        String query = "insert into Account(UserName,Pass,FullName,Gender,City,Email,Phone,IDRole) values(?,null,null,null,null,?,null,?)";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, acc.getUserName());
            ps.setString(2, acc.getEmail());
            ps.setInt(3, 1);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    // them account moi (register)
    public User addAccount(String UserName, String Pass, String FullName, String Gender, String City, String Email,
            String Phone, String IDRole) {
        String query = "insert into Account(UserName,Pass,FullName,Gender,City,Email,Phone,IDRole) values(?,?,?,?,?,?,?,?)";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, UserName);
            ps.setString(2, Pass);
            ps.setString(3, FullName);
            ps.setString(4, Gender);
            ps.setString(5, City);
            ps.setString(6, Email);
            ps.setString(7, Phone);
            ps.setString(8, IDRole);

            ps.executeUpdate();
        } catch (Exception e) {
        }
        return null;
    }

    // chinh sua thong tin account (Update)
    public void updateAccount(String IDAccount, String UserName, String Pass, String FullName, String Gender,
            String City, String Email, String Phone) {
        String query = "update Account set UserName=?, Pass=?, FullName=?, Gender=?, City=? , Email=?, Phone=?  where IDAccount = ?";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, UserName);
            ps.setString(2, Pass);
            ps.setString(3, FullName);
            ps.setString(4, Gender);
            ps.setString(5, City);
            ps.setString(6, Email);
            ps.setString(7, Phone);
            ps.setString(8, IDAccount);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public BookingDetails addBookingDetails(String IDAccount, String IDDiscount, String IDRoomType, String FullName,
            String Gender, String Email, String Phone, String Adult, String Child, String CheckIn, String CheckOut,
            String NumberOfRoom, String TotalPrice, String BookingTime, String Note) {
        String query = "insert into BookingDetails( IDAccount,  IDDiscount, IDRoomType,  FullName, Gender,  Email,  Phone, Adult,  Child,  Checkin,  Checkout,  NumberOfRooms,  TotalPrice,  BookingTime,  Note) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, IDAccount);
            ps.setString(2, IDDiscount);
            ps.setString(3, IDRoomType);
            ps.setString(4, FullName);
            ps.setString(5, Gender);
            ps.setString(6, Email);
            ps.setString(7, Phone);
            ps.setString(8, Adult);
            ps.setString(9, Child);
            ps.setString(10, CheckIn);
            ps.setString(11, CheckOut);
            ps.setString(12, NumberOfRoom);
            ps.setString(13, TotalPrice);
            ps.setString(14, BookingTime);
            ps.setString(15, Note);

            ps.executeUpdate();
        } catch (Exception e) {
        }
        return null;
    }

    public boolean isRoomAvailable(int IDRoomType, Date CheckIn, Date CheckOut) {
        try ( Connection conn = DBContext.getConnection()) {
            // Get the total number of rooms available for the specified room type
            String sql = "SELECT TotalRoom FROM NameRoomType WHERE IDRoomType = ?";
            try ( PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, IDRoomType);
                try ( ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        int totalRooms = rs.getInt("TotalRoom");

                        // Check if there are any overlapping reservations for the specified room type
                        // and date range
                        sql = "SELECT COUNT(*) FROM reservations WHERE IDRoomType = ? "
                                + "AND CheckIn < ? AND CheckOut > ?";
                        try ( PreparedStatement stmt2 = conn.prepareStatement(sql)) {
                            stmt2.setInt(1, IDRoomType);
                            stmt2.setDate(2, new java.sql.Date(CheckOut.getTime()));
                            stmt2.setDate(3, new java.sql.Date(CheckIn.getTime()));
                            try ( ResultSet rs2 = stmt2.executeQuery()) {
                                if (rs2.next()) {
                                    int reservedRooms = rs2.getInt(1);
                                    int availableRooms = totalRooms - reservedRooms;
                                    return availableRooms > 0; // Room is available if there are available rooms left
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Return false in case of any error or exception
    }

    public List<CheckRoomValid> checkRoomValid(String checkIn, String checkOut) {
        List<CheckRoomValid> lcr = new ArrayList<>();
        String query = "SELECT RT.IDRoomType, RT.TotalRoom - COALESCE(SUM(B.NumberOfRooms), 0) AS AvailableRooms\n"
                + "FROM RoomType RT\n"
                + "LEFT JOIN BookingDetails B ON RT.IDRoomType = B.IDRoomType\n"
                + "WHERE (B.Checkin >= ? AND B.Checkin <= ? ) OR\n"
                + "      (B.Checkout >= ? AND B.Checkout <= ? ) OR\n"
                + "      (B.Checkin <= ? AND B.Checkout >= ? )\n"
                + "GROUP BY RT.IDRoomType, RT.TotalRoom;";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, checkIn);
            ps.setString(2, checkOut);
            ps.setString(3, checkIn);
            ps.setString(4, checkOut);
            ps.setString(5, checkIn);
            ps.setString(6, checkOut);
            rs = ps.executeQuery();

            while (rs.next()) {
                lcr.add(new CheckRoomValid(rs.getInt(1),
                        rs.getInt(2)));
            }
        } catch (Exception e) {
        }
        return lcr;
    }

    public User getAccountById(String IDAccount) {
        String query = "select * from Account where IDAccount=?";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, IDAccount);
            rs = ps.executeQuery();
            while (rs.next()) {
                return (new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Contact addContact(String IDAccount, String Name, String Email, String Phone, String Message,
            String Status) {
        String query = "insert into Contact(IDAccount, ContactName,ContactEmail, ContactPhone, ContactMessage, ContactStatus) values(?,?,?,?,?,?)";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, IDAccount);
            ps.setString(2, Name);
            ps.setString(3, Email);
            ps.setString(4, Phone);
            ps.setString(5, Message);
            ps.setString(6, Status);

            ps.executeUpdate();
        } catch (Exception e) {
        }
        return null;
    }

    public List<FAQ> getFeedbacks() {
        List<FAQ> list = new ArrayList<>();
        String query = "select top 5 * from Feedback ORDER BY IDFeedback DESC;";
        try {
            conn = DBContext.getConnection();//mo ket noi
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

    public FAQ addFeedback(String IDAccount, String IDBooking, String CustomerName, String TimeFeedback, String Content, String Rating, String ReplyStatus) {
        String query = "insert into Feedback(IDAccount, IDBooking, CustomerName, TimeFeedBack, Content, Rating, ReplyStatus) values(?,?,?,?,?,?,?)";
        try {
            conn = DBContext.getConnection();// mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, IDAccount);
            ps.setString(2, IDBooking);
            ps.setString(3, CustomerName);
            ps.setString(4, TimeFeedback);
            ps.setString(5, Content);
            ps.setString(6, Rating);
            ps.setString(7, ReplyStatus);

            ps.executeUpdate();
        } catch (Exception e) {
        }
        return null;
    }

    public String getCheckBookingByAccount(int IDAccount) {
        String query = "SELECT COUNT(*)\n"
                + "FROM BookingDetails AS bd\n"
                + "WHERE bd.IDAccount = ?\n"
                + "  AND bd.CheckOut < GETDATE()\n"
                + "  AND NOT EXISTS (\n"
                + "    SELECT 1\n"
                + "    FROM Feedback AS fb\n"
                + "    WHERE fb.IDBooking = bd.IDBooking\n"
                + ");";
        try {
            conn = DBContext.getConnection();//mo ket noi
            ps = conn.prepareStatement(query);
            ps.setInt(1, IDAccount);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public BookingDetails getLastBookingDetailsById(int IDAccount) {
        String query = "select top 1 * from BookingDetails where IDAccount= ? ORDER BY IDBooking DESC";
        try {
            conn = DBContext.getConnection();//mo ket noi
            ps = conn.prepareStatement(query);
            ps.setInt(1, IDAccount);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new BookingDetails(
                        rs.getInt("IDBooking"),
                        rs.getInt("IDAccount"),
                        rs.getInt("IDDiscount"),
                        rs.getInt("IDRoomType"),
                        rs.getString("FullName"),
                        rs.getString("Gender"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getInt("Adult"),
                        rs.getInt("Child"),
                        rs.getString("CheckIn"),
                        rs.getString("CheckOut"),
                        rs.getInt("NumberOfRooms"),
                        rs.getDouble("TotalPrice"),
                        rs.getString("BookingTime"),
                        rs.getString("Note")
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Discount getDiscountView(String Date) {
        String query = "SELECT top 1 * FROM Discount WHERE StartDay < ? AND EndDay > ? AND DiscountValue < 1;";
        try {
            conn = DBContext.getConnection();//mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, Date);
            ps.setString(2, Date);
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

    public String getIDBookingToFeedback(String IDAccount) {
        String query = "select top 1 IDBooking from BookingDetails where IDAccount= ? ORDER BY IDBooking DESC";
        try {
            conn = DBContext.getConnection();//mo ket noi
            ps = conn.prepareStatement(query);
            ps.setString(1, IDAccount);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return null;
    }
  
//    public double calculatePrice(LocalDateTime toDay, LocalDateTime bookingTime, double totalPrice, LocalDateTime checkIn) {
//        BookingDetails b = getLastBookingDetails(9);
//        
//        // Tính thời gian đã mất giữa CheckIn và ToDay
//        Duration timeDifference = Duration.between(checkIn, toDay);
//        Duration totalTime = Duration.between(bookingTime, checkIn);
//        
//        
//        
//
//        // Tính phần trăm thời gian đã mất
//        double cancelTimePercentage = (double) timeDifference.toMillis() / totalTime.toMillis();
//
//        // Tính giá
//        double price = totalPrice * (totalPrice - (totalPrice * cancelTimePercentage));
//        return price;
//    }
//    

}
