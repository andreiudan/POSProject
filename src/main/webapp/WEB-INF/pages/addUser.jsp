<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="AddUser">
  <h1>Add User</h1>
  <form class="needs-validation" novalidate method="post" action="${pageContext.request.contextPath}/AddUser">
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="firstName">First name</label>
        <input type="text" class="form-control" id="firstName" name="firstName" placeholder="" value="" required>
        <div class="invalid-feedback">
          First name is required
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="lastName">Last name</label>
        <input type="text" class="form-control" id="lastName" name="lastName" placeholder="" value="" required>
        <div class="invalid-feedback">
          Last name is required
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="username">Username</label>
        <input type="text" class="form-control" id="username" name="username" placeholder="" value="" required>
        <div class="invalid-feedback">
          Username is required
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="" value="" required>
        <div class="invalid-feedback">
          Password is required
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="position">Position</label>
        <input type="text" class="form-control" id="position" name="position" placeholder="" value="" required>
        <div class="invalid-feedback">
          Position is required
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="user_groups">Groups</label>
        <select class="custom-select d-block w-100" id="user_groups" name="user_groups" multiple>
          <option value="">Choose...</option>
          <c:forEach var="user_group" items="${userGroups}" varStatus="status">
            <option value="${user_group}">${user_group}</option>
          </c:forEach>
        </select>
      </div>
    </div>
    <hr class="nb-4">
    <input  class="btn btn-primary btn-lg" type="submit" value="Submit">
  </form>
</t:pageTemplate>