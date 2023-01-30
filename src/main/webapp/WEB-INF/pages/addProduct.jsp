<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="AddProduct">
  <h1>Add Product</h1>
  <form class="needs-validation" novalidate method="post" action="${pageContext.request.contextPath}/AddProduct">
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="name">Name</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="" value="" required>
        <div class="invalid-feedback">
          Product name is required
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="description">Description</label>
        <input type="text" class="form-control" id="description" name="description" placeholder="" value="" required>
        <div class="invalid-feedback">
          Product description is required
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="quantity">Quantity</label>
        <input type="number" class="form-control" id="quantity" name="quantity" placeholder="" value="1" required>
        <div class="invalid-feedback">
          Quantity of products is required
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="price">Price</label>
        <input type="number" class="form-control" id="price" name="price" placeholder="" value="" required>
        <div class="invalid-feedback">
          Product price is required
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="category">Category</label>
        <input type="text" class="form-control" id="category" name="category" placeholder="" value="" required>
        <div class="invalid-feedback">
          Product description is required
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="barcode">Barcode</label>
        <input type="text" class="form-control" id="barcode" name="barcode" placeholder="" value="" required>
        <div class="invalid-feedback">
          Product barcode is required
        </div>
      </div>
    </div>
    <hr class="nb-4">
    <input  class="btn btn-primary btn-lg" type="submit" value="Submit">
  </form>
</t:pageTemplate>