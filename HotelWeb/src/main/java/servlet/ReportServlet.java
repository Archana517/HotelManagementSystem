package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.DBConnection;
import javax.servlet.annotation.WebServlet;
@WebServlet("/report")
public class ReportServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        try {
            java.sql.Connection con = com.DBConnection.getConnection();
            java.sql.PreparedStatement ps = con.prepareStatement(
                "SELECT SUM(TotalAmount) FROM Reservations");

            java.sql.ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                req.setAttribute("total", rs.getDouble(1));
            }

            RequestDispatcher rd = req.getRequestDispatcher("report_result.jsp");
            rd.forward(req, res);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}