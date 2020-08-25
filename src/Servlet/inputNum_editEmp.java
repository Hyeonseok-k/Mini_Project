package Servlet;

import Database.Employees_DAO;
import Database.Employees_DTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "inputNum_editEmp", urlPatterns ="/inputNum_editEmp")
public class inputNum_editEmp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String num = request.getParameter("Car_Number");

        Employees_DTO.setEmpCar_number(num);
        int empno = Employees_DAO.outempID();


        if (empno == 0) {
            response.sendRedirect("Wrongnumber.jsp");
        } else {
            Employees_DTO.setEmp_ID(empno);
            response.sendRedirect("editEmp.jsp");
        }
    }

    }

