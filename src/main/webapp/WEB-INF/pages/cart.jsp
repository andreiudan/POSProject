<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<t:pageTemplate pageTitle="ShoppingCart">

  <div class="container">
    <h2>Shopping Cart</h2>
    <c:if test="${not empty products}">
      <ul>
        <c:forEach var="product" items="${products}">
          <li>${product.name} - ${product.price}</li>
          <form action="<%= request.getContextPath() %>/Cart" method="post">
            <input type="hidden" name="productId" value="${product.id}"/>
            <input type="submit" value="Add to Cart"/>
          </form>
        </c:forEach>
      </ul>
    </c:if>
  </div>

</t:pageTemplate>