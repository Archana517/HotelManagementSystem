package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import dao.ReservationDAO;
import model.Reservation;
import javax.servlet.annotation.WebServlet;

@WebServlet("/update")
public class UpdateReservationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        Reservation r = new Reservation();
        r.setId(Integer.parseInt(req.getParameter("id")));
        r.setName(req.getParameter("name"));
        r.setRoom(req.getParameter("room"));
        r.setCheckIn(req.getParameter("checkin"));
        r.setCheckOut(req.getParameter("checkout"));
        r.setAmount(Double.parseDouble(req.getParameter("amount")));

        ReservationDAO.update(r);
        res.sendRedirect("display");
    }
}