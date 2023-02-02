<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="CardPayment">
    <h1>Card Payment Method</h1>
    <c:if test="${message != null}">
        <div class="alert alert-warning" role="alert">
                ${message}
        </div>
    </c:if>
    <form class="needs-validation" novalidate method="post" action="${pageContext.request.contextPath}/PayByCard">
        <div class="row">
            <div class="col-md-6 mb-3">
                <div>
                    Total price: ${total} lei
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="cardNumber">Card Number</label>
                <input type="text" class="form-control" id="cardNumber" name="cardNumber" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Card number is required
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="cardExpirationDate">Card Expiration Date</label>
                <input type="date" class="form-control" id="cardExpirationDate" name="cardExpirationDate" placeholder="" value=""
                       required>
                <div class="invalid-feedback">
                    Card expiration date is required
                </div>
            </div>
        </div>
        <hr class="mb-4">
        <input type="hidden" name="total" id="total" value="${total}">
        <input class="btn btn-primary btn-lg" type="submit" value="Submit">
    </form>
</t:pageTemplate>