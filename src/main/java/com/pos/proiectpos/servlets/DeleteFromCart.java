package com.pos.proiectpos.servlets;

import com.pos.proiectpos.ejb.SalesBean;
import jakarta.annotation.security.DeclareRoles;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@DeclareRoles({"CASHIER"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"CASHIER"}))
@WebServlet(name = "DeleteFromCart", value = "/DeleteFromCart")
public class DeleteFromCart extends HttpServlet {

    @Inject
    SalesBean salesBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long productId = Long.parseLong(request.getParameter("id"));
        salesBean.deleteSale(productId);

        response.sendRedirect(request.getContextPath() + "/Cart");
    }
}
