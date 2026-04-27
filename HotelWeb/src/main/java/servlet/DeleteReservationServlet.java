package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import dao.ReservationDAO;
import javax.servlet.annotation.WebServlet;
@WebServlet("/delete")
public class DeleteReservationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        ReservationDAO.delete(id);
        res.sendRedirect("display");
    }
}