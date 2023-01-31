package com.pos.proiectpos.servlets;


import com.pos.proiectpos.common.ProductDto;
import com.pos.proiectpos.common.UserDto;
import com.pos.proiectpos.ejb.ProductsBean;
import com.pos.proiectpos.ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"WRITE_CARS"}))
@WebServlet(name = "EditProduct", value = "/EditProduct")
public class EditProduct extends HttpServlet {
    @Inject
    UserBean userBean;

    @Inject
    ProductsBean productsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserDto> users=userBean.findAllUsers();
        request.setAttribute("users",users);

        Long productId=Long.parseLong(request.getParameter("id"));
        ProductDto product=productsBean.findById(productId);
        request.setAttribute("product",product);

        request.getRequestDispatcher("/WEB-INF/pages/editProduct.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String barcode = request.getParameter("barcode");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        Long productId = Long.parseLong(request.getParameter("product_id"));

        productsBean.updateProduct(productId, name, quantity, price, barcode, description, category);

        response.sendRedirect(request.getContextPath() + "/Products");
    }
}
