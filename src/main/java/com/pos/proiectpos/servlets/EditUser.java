package com.pos.proiectpos.servlets;

import com.pos.proiectpos.common.ProductDto;
import com.pos.proiectpos.common.UserDto;
import com.pos.proiectpos.ejb.ProductsBean;
import com.pos.proiectpos.ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditUser", value = "/EditUser")
public class EditUser extends HttpServlet {
    @Inject
    UserBean userBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserDto> users=userBean.findAllUsers();
        request.setAttribute("users",users);
        Long userId=Long.parseLong(request.getParameter("id"));
        UserDto user=userBean.findById(userId);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/WEB-INF/pages/editUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("user_id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String position = request.getParameter("position");


        userBean.updateUser(userId,username,password,firstName,lastName,position);

        response.sendRedirect(request.getContextPath() + "/Users");
    }
}
