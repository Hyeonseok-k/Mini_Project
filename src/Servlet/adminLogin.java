package Servlet;

import Admin.AdminAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "adminLogin", urlPatterns = "/adminLogin")
public class adminLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String adminID = request.getParameter("admin_ID");
        String adminPW = request.getParameter("admin_password");
        AdminAccount.setInputID(adminID);
        AdminAccount.setInputPass(adminPW);

        if (adminID.equals(AdminAccount.getAdminID()) && adminPW.equals(AdminAccount.getAdminPass())) {
            HttpSession session = request.getSession();
            session.setAttribute("AdminID", adminID);
            response.sendRedirect("admin_main.jsp");
        } else {
            response.sendRedirect("WrongAdmin.jsp");
        }

    }
}
