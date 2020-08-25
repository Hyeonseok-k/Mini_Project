package Servlet;

import Database.Employees_DAO;
import Database.Employees_DTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteEmp", urlPatterns = "/deleteEmp")
public class deleteEmp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String carNumber = request.getParameter("Car_Number");

        if (carNumber.length() < 4) {
            response.sendRedirect("WrongEmpDeleteInput.jsp");
        } else {
            Employees_DTO.setEmpCar_number(carNumber);
            int empNum = Employees_DAO.outempID();
            String name = Employees_DAO.outEmpName();
            Employees_DTO.setEmp_ID(empNum);
            Employees_DTO.setEmp_name(name);
            Employees_DAO.deleteEmp();

            response.sendRedirect("SuccessDeleteEmp.jsp");
        }
    }
}
