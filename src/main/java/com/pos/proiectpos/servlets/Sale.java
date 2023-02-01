package com.pos.proiectpos.servlets;

import com.pos.proiectpos.common.ProductDto;
import com.pos.proiectpos.ejb.ProductsBean;
import com.pos.proiectpos.ejb.SalesBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Sale", urlPatterns = {"/Sale"})
public class Sale extends HttpServlet {

    @Inject
    ProductsBean productsBean;

    @Inject
    SalesBean salesBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductDto> products = productsBean.findAllProducts();

        request.setAttribute("products",products);
        request.setAttribute("activePage","eq");

        request.getRequestDispatcher("/WEB-INF/pages/sale.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] productIdsAsString=request.getParameterValues("product_ids");

        if(productIdsAsString !=null)
        {
            for(String productIdAsString:productIdsAsString){
                if(!salesBean.checkIfSaleExists(Long.parseLong(productIdAsString))){
                    salesBean.createSale(Long.parseLong(productIdAsString));
                }
            }
        }

        response.sendRedirect(request.getContextPath() + "/Cart");
    }
}
