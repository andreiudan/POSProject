<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<t:pageTemplate pageTitle="ShoppingCart">
    <h2>Shopping Cart</h2>
    <form  method="POST" action="">
        <c:if test="${not empty products}">
            <c:forEach var="product" items="${products}" varStatus="status">
                <div class="row">
                    <div class="col">
                        ${product.name}
                    </div>
                    <div class="col">
                        ${product.price}
                    </div>
                    <div class="col">
                        ${sales[status.index].quantity}
                    </div>
                    <div class="col">
                        <a class="btn btn-danger"
                           href="${pageContext.request.contextPath}/DeleteFromCart?id=${product.id}" role="button">Delete</a>
                    </div>
                    <div class="col">
                        <a class="btn btn-primary btn-lg"
                           href="${pageContext.request.contextPath}/EditCart?id=${sales[status.index].id}" role="button">Quantity</a>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </form>
    <br>
    <input type="hidden" name="sales" id="sales" value="${sales}">
    <c:set var="total" value="${0}"/>
    <c:forEach var="product" items="${products}" varStatus="status">
        <c:set var="total" value="${total + (product.price * sales[status.index].quantity)}"/>
    </c:forEach>
    <label>Total: ${total} lei</label>
    <div class="row">
        <div class="col">
            <a class="btn btn-danger"
               href="${pageContext.request.contextPath}/PayByCash?total=${total}" role="button">PayByCash</a>
        </div>
        <div class="col">
            <a class="btn btn-danger"
               href="${pageContext.request.contextPath}/PayByCard?total=${total}" role="button">PayByCard</a>
        </div>
    </div>
</t:pageTemplate>