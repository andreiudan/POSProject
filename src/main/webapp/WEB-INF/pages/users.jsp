<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="u" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
  <h1>Users</h1>
  <form method="POST" action="${pageContext.request.contextPath}/Users">
    <u:if test="${pageContext.request.isUserInRole('ADMIN')}">
      <a href="${pageContext.request.contextPath}/AddUser" class="btn btn-primary btn-lg" >Add User</a>
    </u:if>

    <c:if test="${pageContext.request.isUserInRole('ADMIN') || pageContext.request.isUserInRole('DIRECTOR')}">
      <button class="btn btn-danger" type="submit"> Delete Users</button>
    </c:if>

    <div class="container text-center">
      <div class="row">
        <div class="col">

        </div>
        <div class="col">
          Username
        </div>
        <div class="col">
          First Name
        </div>
        <div class="col">
          Last Name
        </div>
        <div class="col">
          Position
        </div>
        <div class="col">
          Validation
        </div>
        <div class="col">

        </div>
      </div>
      <u:forEach var="user" items="${users}">
        <div class="row">
          <div class="col">
            <input type ="checkbox" name="user_ids" value="${user.id}" />
          </div>
          <div class="col">
              ${user.username}
          </div>
          <div class="col">
              ${user.firstName}
          </div>
          <div class="col">
              ${user.lastName}
          </div>
          <div class="col">
              ${user.position}
          </div>
          <div class="col">
              ${user.validation}
          </div>
        <c:if test="${pageContext.request.isUserInRole('ADMIN') || pageContext.request.isUserInRole('DIRECTOR')}">
          <div class="col">
            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditUser?id=${user.id}">Edit User</a>
          </div>
        </c:if>
      </div>
      </u:forEach>
  </form>

  <c:if test="${not empty invoices}">
    <h2>Invoices</h2>
    <c:forEach var="username" items="${invoices}" varStatus="status">
      ${status.index+1}. ${username}
      <br/>
    </c:forEach>
  </c:if>
</t:pageTemplate>
