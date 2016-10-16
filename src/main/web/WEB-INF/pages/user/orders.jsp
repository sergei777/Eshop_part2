<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 13.09.2016
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:include page="/order-list">--%>
    <%--<jsp:param name="getorderlistbyid" value="${sessionScope.id}" />--%>
<%--</jsp:include>--%>
<t:genericpage>
    <jsp:attribute name="header">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/notify.js"></script>
        <h1>Мои заказы</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <script>
            $(document).ready(function(){
                $("#orders-table").on('click','form',function(){
                    $(this).closest('tr').remove();
                    //var data={};
                    var id = $('input[name="operation"]', this).val();
                    //alert(data.id);
                    $.ajax({
                        type: "GET",
                        url: "remove-order",
                        data: ({
                            id : id
                        }), // serializes the form's elements.
                        dataType: "json",
                        contentType: "application/json",
                        mimeType: 'application/json',
                        success: function()
                        {
                            $.notify("Заказ удален!", "info");
                        }
                    });
                });

            });
        </script>
        <div class="container">
            <table id = "orders-table"class="table">
                <thead>
                <tr>
                    <th>Id заказа</th>
                    <th>Способ оплаты</th>
                    <th>Адрес</th>
                    <th>Статус заказа</th>
                    <th>Товары</th>
                        <%--<th>Адрес</th>--%>
                </tr>
                </thead>
                <c:forEach items="${orders}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.paymentType}</td>
                        <td>${item.addressEntity.streetName} ${item.addressEntity.houseNumber}, кв. ${item.addressEntity.door}</td>
                        <td>${item.orderStatus}</td>
                            <td>
                                <ul class="list-group">
                                    <c:forEach items="${item.products}" var="tmp">
                                    <li class="list-group-item">${tmp.name}</li>
                                </ul>
                                </c:forEach>

                            </td>
                        <td>
                            <form action="javascript:void(null);" method="get">
                            <input type="hidden" id="operation" name="operation" value=${item.id}>
                            <input type="submit" class="btn btn-primary" value="Удалить заказ">
                            </form>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </jsp:body>
</t:genericpage>
