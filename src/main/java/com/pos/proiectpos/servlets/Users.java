package com.pos.proiectpos.servlets;

import com.pos.proiectpos.common.UserDto;
import com.pos.proiectpos.ejb.InvoiceBean;
import com.pos.proiectpos.ejb.UserBean;
import jakarta.annotation.security.DeclareRoles;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@DeclareRoles({"ADMIN", "DIRECTOR"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"ADMIN"}),
        httpMethodConstraints = {@HttpMethodConstraint(value = "POST", rolesAllowed = {"ADMIN"})})
@WebServlet(name = "Users", value = "/Users")
public class Users extends HttpServlet {
    @Inject
    UserBean userBean;

    @Inject
    InvoiceBean invoiceBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserDto> users = userBean.findAllUsers();

        request.setAttribute("users",users);
        request.setAttribute("activePage","eq");

        if (!invoiceBean.getUserIds().isEmpty()){
            Collection<String> usernames=userBean.findUsernamesByUserIds(invoiceBean.getUserIds());
            request.setAttribute("invoices",usernames);
        }

        request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] userIdsAsString= request.getParameterValues("user_ids");
        if(userIdsAsString != null)
        {
            List<Long> userIds=new ArrayList<>();
            for(String userIdasString:userIdsAsString)
            {
                userIds.add(Long.parseLong(userIdasString));
            }
            invoiceBean.getUserIds().addAll(userIds);
        }
        response.sendRedirect(request.getContextPath()+"/Users");

    }

}
