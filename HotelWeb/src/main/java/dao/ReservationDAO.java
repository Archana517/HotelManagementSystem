package dao;

import java.sql.*;
import java.util.*;
import com.DBConnection;
import model.Reservation;

public class ReservationDAO {

    // ADD RESERVATION
    public static int add(Reservation r) {
        int status = 0;
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO reservations(customer_name, room_number, check_in, check_out, total_amount) VALUES (?, ?, ?, ?, ?)"
            );

            ps.setString(1, r.getName());
            ps.setString(2, r.getRoom());

            // FIX DATE FORMAT
            ps.setDate(3, java.sql.Date.valueOf(r.getCheckIn()));
            ps.setDate(4, java.sql.Date.valueOf(r.getCheckOut()));

            ps.setDouble(5, r.getAmount());

            status = ps.executeUpdate();

            System.out.println("Insert Status: " + status); // DEBUG

            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // GET ALL RESERVATIONS
    public static List<Reservation> getAll() {
        List<Reservation> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM reservations");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Reservation r = new Reservation();

                r.setId(rs.getInt("reservation_id"));
                r.setName(rs.getString("customer_name"));
                r.setRoom(rs.getString("room_number"));
                r.setCheckIn(rs.getString("check_in"));
                r.setCheckOut(rs.getString("check_out"));
                r.setAmount(rs.getDouble("total_amount"));

                list.add(r);
            }

            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // DELETE
    public static int delete(int id) {
        int status = 0;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM reservations WHERE reservation_id=?"
            );

            ps.setInt(1, id);
            status = ps.executeUpdate();

            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // UPDATE
    public static int update(Reservation r) {
        int status = 0;
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "UPDATE reservations SET customer_name=?, room_number=?, check_in=?, check_out=?, total_amount=? WHERE reservation_id=?"
            );

            ps.setString(1, r.getName());
            ps.setString(2, r.getRoom());
            ps.setDate(3, java.sql.Date.valueOf(r.getCheckIn()));
            ps.setDate(4, java.sql.Date.valueOf(r.getCheckOut()));
            ps.setDouble(5, r.getAmount());
            ps.setInt(6, r.getId());

            status = ps.executeUpdate();

            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}