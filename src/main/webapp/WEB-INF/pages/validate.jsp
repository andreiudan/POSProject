<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="ShoppingCart">
  <h1>Users Validation</h1>
  <form method="POST" action="${pageContext.request.contextPath}/ValidateUsers">
  <c:if test="${not empty invalidUsers}">
    <button class="btn btn-primary btn-lg" type="submit">Validate Users</button>
    <c:forEach var="invalidUser" items="${invalidUsers}" varStatus="status">
      <div class="row">
        <div class="col">
            ${status.index + 1}. ${invalidUser.firstName}
        </div>
        <div class="col">
            ${invalidUser.lastName}
        </div>
        <div class="col">
            ${invalidUser.username}
        </div>
        <div class="col">
          <input type="checkbox" name="user_ids" value="${invalidUser.id}">
        </div>
      </div>
    </c:forEach>
  </c:if>
  </form>
</t:pageTemplate>
