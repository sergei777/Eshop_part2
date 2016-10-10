<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 12.09.2016
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    tr th,td {
        text-align: center;
        font-size: .95em;
    }
    .button-panel{
        position: relative;
        left: 30%;
    }
</style>
<t:genericadminpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div class="row">
            <div class="col-md-10">
                <table class="table">
                    <thead>
                    <tr>
                        <th>id товара</th>
                        <th>Наименование</th>
                        <th>Цена</th>
                        <th>Категория</th>
                        <th>Вес</th>
                        <th>Количество скоростей</th>
                        <th>Количество товаров</th>
                            <%--<th>Адрес</th>--%>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.productList}" var="item">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.name}</td>
                            <td>${item.price}</td>
                            <td>${item.category}</td>
                            <td>${item.weight}</td>
                            <td>${item.volume}</td>
                            <td>${item.amount}</td>
                            <form action="${pageContext.request.contextPath}/admin/productItem/${item.id}" method="get">
                                <td>
                                    <%--<input type="hidden" name="operation" value="getItemById">--%>
                                    <%--<input type="hidden" name="id" value="${item.id}">--%>
                                    <div class="row">
                                    <input type="submit" class="btn btn-default" value="Редактировать">
                                        </div>
                                </td>
                            </form>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
                <div class="col-md-2">
                    <br>
                    <br>
                    <br>
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Действия</h3>
                        </div>
                        <div class="list-group">
                        <a href="${pageContext.request.contextPath}/admin/newProductItem" class="list-group-item">Добавить товар</a>
                        <a href="${pageContext.request.contextPath}/admin/newCategory" class="list-group-item">Добавить категорию</a>
                            </div>
                    </div>
                </div>

            </div>

        </div>
    </jsp:body>
</t:genericadminpage>
