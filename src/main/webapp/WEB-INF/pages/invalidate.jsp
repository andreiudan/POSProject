<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="ShoppingCart">
    <h1>Users Validation</h1>
    <form method="POST" action="${pageContext.request.contextPath}/InvalidateUsers">
        <c:if test="${not empty validUsers}">
            <button class="btn btn-primary btn-lg" type="submit">Invalidate Users</button>
            <c:forEach var="validUser" items="${validUsers}" varStatus="status">
                <div class="row">
                    <div class="col">
                            ${status.index + 1}. ${validUser.firstName}
                    </div>
                    <div class="col">
                            ${validUser.lastName}
                    </div>
                    <div class="col">
                            ${validUser.username}
                    </div>
                    <div class="col">
                        <input type="checkbox" name="user_ids" value="${validUser.id}">
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </form>
</t:pageTemplate>
