package Servlet;

import Database.CarsDAO;
import Database.CarsDTO;
import Database.DbHandler;
import Database.Employees_DTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpClient;

@WebServlet(name = "getCarNumber", urlPatterns = "/getCarNumber")
public class getCarNumber extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String num = request.getParameter("Car_Number");
        CarsDTO.setCar_Number(num);

        // 직원차량확인
        if (CarsDAO.enterEmpCar() == 0) {
            if (num.length() < 7) {
                response.sendRedirect("WrongEnterNumber.jsp");
            } else {
                if (CarsDAO.isExist() == 0) {
                    CarsDTO.setCar_Number(num);
                    DbHandler.insertCar();
                    response.sendRedirect("SuccessEnterCar.jsp");
                } else {
                    response.sendRedirect("alreadyExist.jsp");
                }
            }
        } else {
            Employees_DTO.setEmpCar_number(num);
            CarsDTO.setIs_Employees_car(true);
            CarsDAO.addCar();
            response.sendRedirect("EnterEmpCar.jsp");
        }
    }
}
