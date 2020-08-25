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

@WebServlet(name = "Final_payment", urlPatterns = "/Final_payment")
public class Final_payment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 최종요금을 가져옴
        int fee = FeeCalcu.feeCal() - (int)(FeeCalcu.feeCal() * Discount.getRate());
        Discount.setFinalFee(fee);
        int finalfee = Discount.getFinalFee();
        // 전체금액할인이면 바로 결제완료 페이지로
        if (finalfee == 0) {
            DbHandler.OutCar();
            response.sendRedirect("SuccessPayment.jsp");
        } else {
            response.sendRedirect("payment.jsp");
        }


    }


}


