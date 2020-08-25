package Servlet;

import Database.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

@WebServlet(name = "startpay", urlPatterns = "/startPay")
public class startPay extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");

            String num = request.getParameter("Car_Number");
            CarsDTO.setCar_Number(num);
            if (CarsDAO.enterEmpCar() == 0) {
                Timestamp inTime = Car_ParkDAO.getInTime();
                if (inTime == null) {
                    response.sendRedirect("Wrongnumber.jsp");
                } else {
                    Car_ParkDAO.updateOuttime();
                    response.sendRedirect("startPay.jsp");
                }
            } else {
                Employees_DTO.setEmpCar_number(num);
                response.sendRedirect("EnterEmpCar.jsp");
            }







    }
}
