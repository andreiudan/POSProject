<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="EditCart">
    <h1>Edit Cart</h1>
    <form class="needs-validation" novalidate method="post" action="${pageContext.request.contextPath}/EditCart">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="quantity">Quantity</label>
                <input type="number" class="form-control" id="quantity" name="quantity" placeholder="" value="${sale.quantity}" required>
                <div class="invalid-feedback">
                    Quantity is required
                </div>
            </div>
        </div>
        <hr class="mb-4">
        <input type="hidden" name="sale_id" value="${sale.id}" />
        <input  class="btn btn-primary btn-lg" type="submit" value="Update">
    </form>
</t:pageTemplate>