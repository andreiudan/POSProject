<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<t:pageTemplate pageTitle="ShoppingCart">
    <h2>Shopping Cart</h2>
    <form  method="POST" action="">
        <c:if test="${not empty products}">
            <c:forEach var="product" items="${products}">
                <div class="row">
                    <div class="col">
                        ${product.name}
                    </div>
                    <div class="col">
                        ${product.price}
                    </div>
                    <div class="col">
                        <input type="number" name="quantity" id="quantity" placeholder="" value="1" min="1" max="${product.quantity}">
                    </div>
                    <div class="col">
                        <a class="btn btn-danger"
                           href="${pageContext.request.contextPath}/DeleteFromCart?id=${product.id}" role="button">Delete</a>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </form>
    <br>
    <div class="col">
        <a class="btn btn-danger"
           href="${pageContext.request.contextPath}/DeleteFromCart?id=${product.id}" role="button">PayByCash</a>
    </div>
    <label>Total:</label>
</t:pageTemplate>