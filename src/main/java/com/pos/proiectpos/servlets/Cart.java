package com.pos.proiectpos.servlets;

import com.pos.proiectpos.common.ProductDto;
import com.pos.proiectpos.common.SalesDto;
import com.pos.proiectpos.ejb.ProductsBean;

import com.pos.proiectpos.ejb.ReceiptBean;
import com.pos.proiectpos.ejb.SalesBean;
import com.pos.proiectpos.entities.Receipt;
import jakarta.annotation.security.DeclareRoles;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@DeclareRoles({"CASHIER"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"CASHIER"}))
@WebServlet(name = "Cart", value = "/Cart")
public class Cart extends HttpServlet {
    @Inject
    ProductsBean productsBean;

    @Inject
    SalesBean salesBean;

    @Inject
    ReceiptBean receiptBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Long> salesProductIds = salesBean.findAllSalesIds();
        List<ProductDto> products = new ArrayList<>();
        List<SalesDto> sales = new ArrayList<>();

        if (salesProductIds != null) {
            products = productsBean.findProductsByIds(salesProductIds);
            sales = salesBean.findAllSales();
        }

        request.setAttribute("products", products);
        request.setAttribute("sales", sales);
        request.setAttribute("activePage", "cart");
        request.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
