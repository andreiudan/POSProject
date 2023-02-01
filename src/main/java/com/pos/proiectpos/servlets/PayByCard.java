package com.pos.proiectpos.servlets;

import com.pos.proiectpos.common.SalesDto;
import com.pos.proiectpos.ejb.PayByCardBean;
import com.pos.proiectpos.ejb.ReceiptBean;
import com.pos.proiectpos.ejb.SalesBean;
import com.pos.proiectpos.ejb.UserBean;
import com.pos.proiectpos.entities.Sales;
import jakarta.ejb.SessionBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "PayByCard", value = "/PayByCard")
public class PayByCard  extends HttpServlet {

    @Inject
    PayByCardBean payByCardBean;

    @Inject
    ReceiptBean receiptBean;

    @Inject
    SalesBean salesBean;

    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("total",request.getParameter("total"));

        String username = request.getUserPrincipal().getName();
        Long cashierId = userBean.findUserByUsername(username).getId();

        receiptBean.createReceipt(cashierId,salesBean.findAllSales());

        request.getRequestDispatcher("/WEB-INF/pages/payByCard.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cardNumber = request.getParameter("cardNumber");
        String cardExpirationDate = request.getParameter("cardExpirationDate");
        Double total = Double.parseDouble(request.getParameter("total"));

        payByCardBean.createPayByCard(cardNumber,cardExpirationDate,total);

        request.setAttribute("message","Payment successful!");
        request.setAttribute("total",request.getParameter("total"));

        request.getRequestDispatcher("/WEB-INF/pages/payByCard.jsp").forward(request,response);
    }
}
