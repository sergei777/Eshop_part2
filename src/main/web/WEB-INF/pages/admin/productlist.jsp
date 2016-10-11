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
<%--<%@ include file="dialog.jsp" %>--%>
<style>
    tr th, td {
        text-align: center;
        font-size: .95em;
    }

    .button-panel {
        position: relative;
        left: 30%;
    }
</style>
<t:genericadminpage>
    <jsp:attribute name="header">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
                                <td>${item.category.category}</td>
                                <td>${item.weight}</td>
                                <td>${item.volume}</td>
                                <td>${item.amount}</td>
                                <form action="${pageContext.request.contextPath}/admin/productItem/${item.id}"
                                      method="get">
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
                            <a href="${pageContext.request.contextPath}/admin/newProductItem" class="list-group-item">Добавить
                                товар</a>
                            <a href="" data-toggle="modal" data-target="#myModalNorm" s class="list-group-item"
                               data-target="#myModalNorm">Добавить категорию</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="myModalNorm" tabindex="-1" role="dialog"
             aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <button type="button" class="close"
                                data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Закрыть</span>
                        </button>
                        <h4 class="modal-title text-center" id="myModalLabel">
                            Добавление новой категории
                        </h4>
                    </div>

                    <!-- Modal Body -->
                    <div class="modal-body">
                        <form action="javascript:void(null);" onsubmit="acall();return false;" method="post" role="form" name="addCategory">
                            <div class="form-group text-center">
                                <input type="text" class="form-control" name="category"
                                       id="exampleInputEmail1" placeholder="например: горные"/>
                            </div>
                            <button type="submit" class="btn btn-primary center-block">Добавить</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function acall(){
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/admin/newCategory",
                    data: document.addCategory.elements['category'].value,
                    dataType: "json",
                    contentType: "application/json",
                    mimeType: 'application/json',
                    success: function () {
                        $('#myModalNorm').modal('hide');
                        alert("Данные успешно добавлены!")
                    }
                });
            }
        </script>
    </jsp:body>
</t:genericadminpage>
