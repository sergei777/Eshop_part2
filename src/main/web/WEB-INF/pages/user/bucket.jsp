<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 07.09.2016
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:genericpage>
    <jsp:attribute name="header">
        <h1>Корзина</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <table class="table">
                <thead>
                <tr>
                    <th>Название товара</th>
                    <th>Цена</th>
                    <th>Количество</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sessionScope.shoppingCart.shoppingList}" var="item">
                    <tr>
                        <td>${item.name}</td>
                        <td>${item.price}</td>
                        <td>${item.amount}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/shopping-cart" method="GET">
                                <input type="hidden" name="action" value="removeItemById">
                                <input type="hidden" name="id" value="${item.id}">
                                <input type="submit" class="btn btn-default" value="Удалить товар">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
                <tr>
                    <th>Итого: ${sessionScope.shoppingCart.totalPrice} рублей</th>
                    <th></th>
                    <th></th>
                </tr>
            </table>
            <form action="${pageContext.request.contextPath}/order.jsp" method="GET">
                <input type="submit" class="btn btn-default" value="Оформить заказ"
                <c:if test="${empty sessionScope.first_name}">
                       disabled title="Необходимо зарегистрироваться"
                </c:if>
                <c:if test="${empty sessionScope.shoppingCart}">
                       disabled title="Нет товаров в корзине"
                </c:if>
                <c:if test="${!empty sessionScope.shoppingCart}">
                <c:if test="${sessionScope.shoppingCart.totalAmount==0}">
                       disabled title="Нет товаров в корзине"
                </c:if>
                </c:if>
                >
            </form>
        </div>
    </jsp:body>
</t:genericpage>