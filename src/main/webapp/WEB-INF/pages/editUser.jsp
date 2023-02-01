<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="EditUser">
    <h1>Edit User</h1>
    <form class="needs-validation" novalidate method="post" action="${pageContext.request.contextPath}/EditUser">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="username">username</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="" value="${user.username}" required>
                <div class="invalid-feedback">
                    Username is required
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="password">password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="password" value="" required>
                <div class="invalid-feedback">
                    Password is required
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="firstName">firstName</label>
                <input type="text" class="form-control" id="firstName" name="firstName" placeholder="" value="${user.firstName}" required>
                <div class="invalid-feedback">
                    FirstName is required
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="lastName">lastName</label>
                <input type="text" class="form-control" id="lastName" name="lastName" placeholder="" value="${user.lastName}" required>
                <div class="invalid-feedback">
                    LastName is required
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="position">position</label>
                <input type="text" class="form-control" id="position" name="position" placeholder="" value="${user.position}" required>
                <div class="invalid-feedback">
                    Position is required
                </div>
            </div>
        </div>
        <hr class="mb-4">
        <input type="hidden" name="user_id" value="${user.id}" />
        <input  class="btn btn-primary btn-lg" type="Submit" value="Update">
    </form>
</t:pageTemplate>