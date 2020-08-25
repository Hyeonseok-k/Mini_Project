package Servlet;

import Database.Employees_DAO;
import Database.Employees_DTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editEmp", urlPatterns = "/editEmp")
public class editEmp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String newName = request.getParameter("new_Name");
        String newCarNum = request.getParameter("Car_Number");

        if (newCarNum.length() < 4 ) {
            response.sendRedirect("Wrongnumber.jsp");
        } else {
            Employees_DTO.setEmp_name(newName);
            Employees_DTO.setEmpCar_number(newCarNum);
            Employees_DAO.updateEmp();
            response.sendRedirect("resultEdit.jsp");
        }
    }


}
