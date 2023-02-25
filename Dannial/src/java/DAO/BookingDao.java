package DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Services.Booking;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Ahmad Dannial Dzulkarnain
 */
public class BookingDao {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dannial", "root", "");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static int save(Booking e) {
        int status = 0;
        try {
            Connection con = BookingDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into booking(description) values (?)");

            ps.setString(1, e.getDescription());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static int update(Booking e) {
        int status = 0;
        try {
            Connection con = BookingDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update booking set description=? where id=?");

            ps.setString(1, e.getDescription());
            ps.setInt(2, e.getId());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection con = BookingDao.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from booking where id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static Booking getBookingById(int id) {
        Booking e = new Booking();

        try {
            Connection con = BookingDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from booking where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setId(rs.getInt(1));
                e.setDescription(rs.getString(2));
            }

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }

    public static List<Booking> getAllBooking() {
        List<Booking> list = new ArrayList<Booking>();

        try {
            Connection con = BookingDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from booking");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Booking e = new Booking();
                e.setId(rs.getInt(1));
                e.setDescription(rs.getString(2));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
