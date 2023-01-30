<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="EditProduct">
    <h1>Edit Product</h1>
    <form class="needs-validation" novalidate method="post" action="${pageContext.request.contextPath}/EditProduct">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="password">Name</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="" value="${user.username}" required>
                <div class="invalid-feedback">
                    Name is required
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="password">Description</label>
                <input type="text" class="form-control" id="password" name="password" placeholder="" value="${user.password}" required>
                <div class="invalid-feedback">
                    Description is required
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="firstName">Quantity</label>
                <input type="number" class="form-control" id="firstName" name="firstName" placeholder="" value="${user.firstName}" required>
                <div class="invalid-feedback">
                    Quantity is required
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="lastName">Price</label>
                <input type="number" class="form-control" id="lastName" name="lastName" placeholder="" value="${user.lastName}" required>
                <div class="invalid-feedback">
                    Price is required
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="position">Category</label>
                <input type="text" class="form-control" id="position" name="position" placeholder="" value="${user.position}" required>
                <div class="invalid-feedback">
                    Category is required
                </div>
            </div>
        </div>
        <hr class="mb-4">
        <input type="hidden" name="user_id" value="${user.id}" />
        <input  class="btn btn-primary btn-lg" type="Submit" value="Update">
    </form>
</t:pageTemplate>