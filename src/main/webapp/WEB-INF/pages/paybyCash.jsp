<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="PayByCard">
  <h1>Edit Product</h1>
  <form class="needs-validation" novalidate method="post" action="${pageContext.request.contextPath}/PayByCash">
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="Total">Total</label>
        <input type="text" class="form-control" id="Total" name="Total" placeholder="" value=""  required>
        <div class="invalid-feedback">
          Total money is required
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="quantity">Quantity</label>
        <input type="number" class="form-control" id="quantity" name="quantity" placeholder="" value="1" min="1" max="${product.quantity}" required>
        <div class="invalid-feedback">
          Quantity is required
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="Amount of money">Quantity</label>
        <input type="number" class="form-control" id="Amount of money" name="Amount of money" placeholder="" value="" required>
        <div class="invalid-feedback">
          Money is required
        </div>
      </div>
    </div>
    <hr class="mb-4">
    <input  class="btn btn-primary btn-lg" type="Pay" value="Submit">
  </form>
</t:pageTemplate>