package Servlet;

import Database.Employees_DAO;
import Database.Employees_DTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addEmp", urlPatterns = "/addEmp")
public class addEmp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String name = request.getParameter("emp_name");
        String carNumber = request.getParameter("emp_car_number");

        Employees_DTO.setEmp_name(name);
        Employees_DTO.setEmpCar_number(carNumber);

        String getName = Employees_DTO.getEmp_name();
        String getNumber = Employees_DTO.getEmpCar_number();

        if (getName == null || getNumber.length() < 4) {
            response.sendRedirect("WrongEmpAddInput.jsp");
        } else {
            Employees_DAO.addEmp();
            response.sendRedirect("SuccessAddEmp.jsp");
        }
    }
}
