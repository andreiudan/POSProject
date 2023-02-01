package com.pos.proiectpos.servlets;

import com.pos.proiectpos.common.ProductDto;
import com.pos.proiectpos.ejb.ProductsBean;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Cart", value = "/Cart")
public class Cart extends HttpServlet {
    @Inject
    ProductsBean productsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<ProductDto> products = (List<ProductDto>) session.getAttribute("cart");
        if (products == null) {
            products = new ArrayList<>();
        }
        request.setAttribute("products", products);
        request.setAttribute("activePage", "cart");
        request.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productIdAsString = request.getParameter("product_id");
        if (productIdAsString != null) {
            long productId = Long.parseLong(productIdAsString);
            ProductDto product = productsBean.findById(productId);
            HttpSession session = request.getSession();
            List<ProductDto> products = (List<ProductDto>) session.getAttribute("cart");
            if (products == null) {
                products = new ArrayList<>();
            }
            products.add(product);
            session.setAttribute("cart", products);
        }
        response.sendRedirect(request.getContextPath() + "/Cart");
    }
}
