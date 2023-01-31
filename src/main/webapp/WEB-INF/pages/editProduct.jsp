<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="EditProduct">
    <h1>Edit Product</h1>
    <form class="needs-validation" novalidate method="post" action="${pageContext.request.contextPath}/EditProduct">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="" value="${product.name}" required>
                <div class="invalid-feedback">
                    Name is required
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="description">Description</label>
                <input type="text" class="form-control" id="description" name="description" placeholder="" value="${product.description}" required>
                <div class="invalid-feedback">
                    Description is required
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="quantity">Quantity</label>
                <input type="number" class="form-control" id="quantity" name="quantity" placeholder="" value="${product.quantity}" required>
                <div class="invalid-feedback">
                    Quantity is required
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="price">Price</label>
                <input type="number" class="form-control" id="price" name="price" placeholder="" value="${product.price}" required>
                <div class="invalid-feedback">
                    Price is required
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="category">Category</label>
                <input type="text" class="form-control" id="category" name="category" placeholder="" value="${product.category}" required>
                <div class="invalid-feedback">
                    Category is required
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="barcode">Barcode</label>
                <input type="text" class="form-control" id="barcode" name="barcode" placeholder="" value="${product.barcode}" required>
                <div class="invalid-feedback">
                    Barcode is required
                </div>
            </div>
        </div>
        <hr class="mb-4">
        <input type="hidden" name="product_id" value="${product.id}" />
        <input  class="btn btn-primary btn-lg" type="Submit" value="Update">
    </form>
</t:pageTemplate>