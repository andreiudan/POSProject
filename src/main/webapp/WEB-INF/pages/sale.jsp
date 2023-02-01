<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Products">
  <h1>Products</h1>
  <form method="POST" action="${pageContext.request.contextPath}/Sale">

    <c:if test="${pageContext.request.isUserInRole('CASHIER')}">
      <div class="col">
        <button class="btn btn-primary btn-lg" type="submit">Add to Cart</button>
      </div>
    </c:if>
  <div class="container text-center">
  <div class="row">
    <c:if test="${pageContext.request.isUserInRole('CASHIER')}">
      <div class="col">

      </div>
    </c:if>
    <div class="col">
      Name
    </div>
    <div class="col">
      Description
    </div>
    <div class="col">
      Category
    </div>
    <div class="col">
      Quantity
    </div>
    <div class="col">
      Price
    </div>
    <div class="col">
      Photo
    </div>
    <c:if test="${pageContext.request.isUserInRole('ADMIN') || pageContext.request.isUserInRole('DIRECTOR')}">
      <div class="col">

      </div>
      <div class="col">

      </div>
    </c:if>
  </div>
    <c:forEach var="product" items="${products}">
      <div class="row">
        <c:if test="${pageContext.request.isUserInRole('CASHIER')}">
        <div class="col">
          <input type ="checkbox" name="product_ids" value="${product.id}" />
        </div>
        </c:if>
        <div class="col">
            ${product.name}
        </div>
        <div class="col">
            ${product.description}
        </div>
        <div class="col">
            ${product.category}
        </div>
        <div class="col">
            ${product.quantity}
        </div>
        <div class="col">
            ${product.price}
        </div>
        <div class="col">
          <img src="${pageContext.request.contextPath}/ProductPhotos?id=${product.id}" witdh="48" height="40"/>
        </div>
        <c:if test="${pageContext.request.isUserInRole('CASHIER')}">
          <div class="col">
            <label>Quantity</label>
            <input type="number" name="quantity" id="quantity" placeholder="" value="" min="0">
          </div>
        </c:if>
      </div>
    </c:forEach>
  </form>
</t:pageTemplate>