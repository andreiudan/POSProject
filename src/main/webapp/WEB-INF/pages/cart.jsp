<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<t:pageTemplate pageTitle="ShoppingCart">
    <h2>Shopping Cart</h2>
    <c:if test="${not empty products}">
        <div class="row">
            <c:forEach var="product" items="${products}">
                <div class="col">
                    ${product.name}
                </div>
                <div class="col">
                    ${product.price}
                </div>
            </c:forEach>
        </div>
    </c:if>
</t:pageTemplate>