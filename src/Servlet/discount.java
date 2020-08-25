package Servlet;

import Discount.Discount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "discount", urlPatterns = "/discount")
public class discount extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Money = request.getParameter("spend_money");
        System.out.println(Money);
        int spendMoney = Integer.parseInt(Money);
        Discount.setSpendMoney(spendMoney);
        response.sendRedirect("final_pay.jsp");
    }
}
