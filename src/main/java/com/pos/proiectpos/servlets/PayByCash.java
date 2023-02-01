package com.pos.proiectpos.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "PayByCash", value = "/PayByCash")
public class PayByCash extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("total",request.getParameter("total"));

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
