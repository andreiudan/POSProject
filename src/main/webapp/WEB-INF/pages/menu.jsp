<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}">POS</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf
                        ("/")) eq '/about.jsp' ? ' active' : ''}" aria-current="page" href="${pageContext.request.contextPath}/about.jsp">About</a>
                    </li>
                    <li class="nav-item">
                        <c:choose>
                            <c:when test="${pageContext.request.isUserInRole('CASHIER')}">
                                <a class="nav-link
                         ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf("/")) eq '/sale.jsp' ? ' active' : ''}"
                                   href="${pageContext.request.contextPath}/Sale">Products</a>
                            </c:when>
                            <c:otherwise>
                                <a class="nav-link
                         ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf("/")) eq '/products.jsp' ? ' active' : ''}"
                                   href="${pageContext.request.contextPath}/Products">Products</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                    <li class="nav-item">
                        <c:if test="${pageContext.request.isUserInRole('ADMIN')}">
                            <a class="nav-link
                             ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf  ("/")) eq '/users.jsp' ? ' active' : ''}"
                               aria-current="page" href="${pageContext.request.contextPath}/Users">Users</a>
                        </c:if>
                    </li>
                    <li class="nav-item">
                        <c:if test="${pageContext.request.isUserInRole('CASHIER')}">
                            <a class="nav-link
                             ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf  ("/")) eq '/cart.jsp' ? ' active' : ''}"
                               aria-current="page" href="${pageContext.request.contextPath}/Cart">Cart</a>
                        </c:if>
                    </li>
                    <li class="nav-item">
                        <c:if test="${pageContext.request.isUserInRole('DIRECTOR')}">
                            <a class="nav-link
                             ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf("/")) eq '/validate.jsp' ? ' active' : ''}"
                               aria-current="page" href="${pageContext.request.contextPath}/ValidateUsers">Validate</a>
                        </c:if>
                    </li>
                    <li class="nav-item">
                        <c:if test="${pageContext.request.isUserInRole('DIRECTOR')}">
                            <a class="nav-link
                             ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf("/")) eq '/invalidate.jsp' ? ' active' : ''}"
                               aria-current="page" href="${pageContext.request.contextPath}/InvalidateUsers">Invalidate</a>
                        </c:if>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <c:choose>
                            <c:when test="${pageContext.request.getRemoteUser() == null}">
                                <a class="nav-link" href="${pageContext.request.contextPath}/Login">Login</a>
                            </c:when>
                            <c:otherwise>
                                <a class="nav-link" href="${pageContext.request.contextPath}/Logout">Logout</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>