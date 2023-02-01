package com.pos.proiectpos.servlets;

import com.pos.proiectpos.ejb.ReceiptBean;
import com.pos.proiectpos.ejb.SalesBean;
import com.pos.proiectpos.ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "PayByCash", value = "/PayByCash")
public class PayByCash extends HttpServlet {

    @Inject
    UserBean userBean;

    @Inject
    ReceiptBean receiptBean;

    @Inject
    SalesBean salesBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("total",request.getParameter("total"));

        String username = request.getUserPrincipal().getName();
        Long cashierId = userBean.findUserByUsername(username).getId();

        receiptBean.createReceipt(cashierId,salesBean.findAllSales());

        request.getRequestDispatcher("/WEB-INF/pages/payByCash.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double total = Double.parseDouble(request.getParameter("total"));
        Double cash = Double.parseDouble(request.getParameter("cash"));

        if(cash>=total){
            request.setAttribute("message","Payment successful! <br /> Change: "+(cash-total));
        }else{
            request.setAttribute("message","Not enough money");
        }

        request.setAttribute("total",request.getParameter("total"));

        request.getRequestDispatcher("/WEB-INF/pages/payByCash.jsp").forward(request,response);
    }
}
