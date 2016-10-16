<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>velosipedov.net</title>

    <!-- Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
          crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            crossorigin="anonymous"></script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/generictag.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div id="pageheader">
        <jsp:invoke fragment="header"/>
        <nav class="navbar navbar-default">
            <div class="headerclass">
                <ul class="nav navbar-nav center-block">
                    <li><a href="${pageContext.request.contextPath}/home">На главную</a></li>
                    <li><a href="${pageContext.request.contextPath}/product/getProducts/1/6">Каталог товаров</a></li>
                    <li><a href="${pageContext.request.contextPath}/contacts">Контакты</a></li>
                </ul>

                <div class="div-bucket-buttons div-button">
                    <div>
                        <security:authorize access="hasRole('ROLE_ANONYMOUS')">
                            <a href="${pageContext.request.contextPath}/loginform" class="btn btn-default">Вход</a>
                            <a href="${pageContext.request.contextPath}/registrationform" class="btn btn-default">Регистрация</a>
                        </security:authorize>
                        <%--<c:if test="${empty sessionScope.first_name}">--%>
                            <%--<a href="${pageContext.request.contextPath}/loginform" class="btn btn-default">Вход</a>--%>
                            <%--<a href="${pageContext.request.contextPath}/registrationForm.jsp" class="btn btn-default">Регистрация</a>--%>
                        <%--</c:if>--%>
                        <%--<c:if test="${!empty sessionScope.first_name}">--%>
                            <security:authorize access="hasRole('ROLE_USER')">
                            <a href="${pageContext.request.contextPath}/user/orders" class="btn btn-default">Мои
                                заказы</a>

                            <a href="${pageContext.request.contextPath}/logout" class="btn btn-default">Выход</a>
                            <div class="btn">
                                <a href="${pageContext.request.contextPath}/user/settings">
                                    <div class="div-settings">
                                        <img src="http://s1.iconbird.com/ico/2014/1/567/w512h5121389807746applicationdefaulticon.png">
                                    </div>
                                </a>
                            </div>
                            </security:authorize>
                        <%--</c:if>--%>
                    </div>
                </div>
            </div>
        </nav>
    </div>
</div>

<div class="div-bucket-element">
    <h5 class="text-center">Привет,${!empty sessionScope.first_name ? sessionScope.first_name : "гость"}!</h5>
    <a href="${pageContext.request.contextPath}/bucket/bucketPage">
        <%--<img src="http://iconspot.ru/files/287498.png"--%>
            <img src=http://simpleicon.com/wp-content/uploads/shopping-cart-8.png
             width="70%"
             height="70%"
             class="center-block">
    </a>
    <h5 class="text-center">Корзина : ${!empty sessionScope.shoppingCart ? sessionScope.shoppingCart.totalAmount : "0"}
        товаров</h5>
</div>
<jsp:doBody/>
<jsp:invoke fragment="footer"/>
</body>
</html>