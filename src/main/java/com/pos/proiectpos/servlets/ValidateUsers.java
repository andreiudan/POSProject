package com.pos.proiectpos.servlets;

import com.pos.proiectpos.common.UserDto;
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
import java.util.List;

@DeclareRoles("DIRECTOR")
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"DIRECTOR"}),
        httpMethodConstraints = {@HttpMethodConstraint(value = "POST", rolesAllowed = {"DIRECTOR"})})
@WebServlet(name = "ValidateUsers", value = "/ValidateUsers")
public class ValidateUsers extends HttpServlet {

    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserDto> invalidUsers = userBean.findAllInvalidUsers();
        request.setAttribute("invalidUsers", invalidUsers);

        request.getRequestDispatcher("/WEB-INF/pages/validate.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] usersIdsToValidate = request.getParameterValues("user_ids");

        if (usersIdsToValidate != null) {
            for (String userIdAsString : usersIdsToValidate) {
                userBean.validateUser(Long.parseLong(userIdAsString));
            }
        }
        response.sendRedirect(request.getContextPath() + "/ValidateUsers");
    }
}
