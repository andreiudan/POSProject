<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Products">
  <h1>Products</h1>
    <form method="POST" action="${pageContext.request.contextPath}/Products">
      <c:if test="${pageContext.request.isUserInRole('WRITE_CARS')}">
      <a href="${pageContext.request.contextPath}/AddProduct" class="btn btn-primary btn-lg" >Add product</a>
      </c:if>
      <c:if test="${pageContext.request.isUserInRole('WRITE_CARS')}">
      <button class="btn btn-danger" type="submit"> Delete Products</button>
      </c:if>

      <div class="container text-center">
        <div class="row">
          <div class="col">

          </div>
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
          <div class="col">

          </div>
          <div class="col">

          </div>
        </div>
        <c:forEach var="product" items="${products}">
        <div class="row">
          <div class="col">
            <input type ="checkbox" name="product_ids" value="${product.id}" />
          </div>
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
          <c:if test="${pageContext.request.isUserInRole('WRITE_CARS')}">
            <div class="col">
              <a class="btn btn-secondary"
                 href="${pageContext.request.contextPath}/AddProductPhoto?id=${product.id}" role="button">Add photo</a>
            </div>
            <div class="col">
              <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditProduct?id=${product.id}">Edit Product</a>
            </div>
          </c:if>
        </div>
        </c:forEach>
    </form>

</t:pageTemplate>