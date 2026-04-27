package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/reportCriteria")
public class ReportCriteriaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        req.setAttribute("from", req.getParameter("from"));
        req.setAttribute("to", req.getParameter("to"));

        RequestDispatcher rd = req.getRequestDispatcher("report_result.jsp");
        rd.forward(req, res);
    }
}