package Servlet;

import Database.DbHandler;
import Discount.Discount;
import Payment.FeeCalcu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "payment", urlPatterns = "/payment")
public class payment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int fee = FeeCalcu.feeCal() - (int)(FeeCalcu.feeCal() * Discount.getRate());
        String str = request.getParameter("input_fee");
        int inputfee = Integer.parseInt(str);

        if (inputfee == fee) {
            DbHandler.OutCar();
            response.sendRedirect("SuccessPayment.jsp");
        } else {
            response.sendRedirect("FailPayment.jsp");
        }
    }
}
