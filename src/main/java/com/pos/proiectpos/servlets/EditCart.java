package com.pos.proiectpos.servlets;

import com.pos.proiectpos.common.ProductDto;
import com.pos.proiectpos.common.SalesDto;
import com.pos.proiectpos.ejb.SalesBean;
import jakarta.annotation.security.DeclareRoles;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@DeclareRoles({"CASHIER"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"CASHIER"}))
@WebServlet(name = "EditCart", value = "/EditCart")
public class EditCart extends HttpServlet {

    @Inject
    SalesBean salesBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SalesDto> sales =salesBean.findAllSales();
        request.setAttribute("sales",sales);

        Long saleId=Long.parseLong(request.getParameter("id"));
        SalesDto sale=salesBean.findById(saleId);
        request.setAttribute("sale",sale);

        request.getRequestDispatcher("/WEB-INF/pages/editCart.jsp").forward(request,response);




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Long saleId = Long.parseLong(request.getParameter("sale_id"));
        salesBean.updateSale(saleId,quantity);
        response.sendRedirect(request.getContextPath() + "/Cart");
    }
}