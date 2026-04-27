

package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import dao.ReservationDAO;
import model.Reservation;

@WebServlet("/add")
public class AddReservationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        Reservation r = new Reservation();
        r.setName(req.getParameter("name"));
        r.setRoom(req.getParameter("room"));
        r.setCheckIn(req.getParameter("checkin"));
        r.setCheckOut(req.getParameter("checkout"));
        r.setAmount(Double.parseDouble(req.getParameter("amount")));

        ReservationDAO.add(r);
        res.sendRedirect("display");
    }
}