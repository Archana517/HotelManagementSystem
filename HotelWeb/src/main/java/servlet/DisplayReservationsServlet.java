package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import dao.ReservationDAO;
import javax.servlet.annotation.WebServlet;
@WebServlet("/display")
public class DisplayReservationsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        req.setAttribute("list", ReservationDAO.getAll());
        RequestDispatcher rd = req.getRequestDispatcher("reservationdisplay.jsp");
        rd.forward(req, res);
    }
}