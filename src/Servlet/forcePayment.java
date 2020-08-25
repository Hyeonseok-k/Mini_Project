package Servlet;

import Database.CarsDAO;
import Database.CarsDTO;
import Database.DbHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "forcePayment", urlPatterns = "/forcePayment")
public class forcePayment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
    String num = request.getParameter("Car_Number");

        CarsDTO.setCar_Number(num);
        DbHandler.OutCar();

        response.sendRedirect("SuccessPayment.jsp");
    }
}
