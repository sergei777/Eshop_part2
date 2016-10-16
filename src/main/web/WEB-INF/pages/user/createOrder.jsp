<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 11.09.2016
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:attribute name="header">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <h1>Товар</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div id="login-overlay" class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title text-center" id="makeOrder">Оформление заказа</h4>
                    </div>
                    <div class="modal-body">
                        <%--<form id="order" action="${pageContext.request.contextPath}/make-order" method="POST">--%>
                            <form id="order" action="javascript:void(null);" onsubmit="acall()" method="post" name = "orderform" >
                            <div class="col-xs-4">
                                <label>Страна</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" name="country" value="${address.country}" placeholder="Страна"
                                           required >
                                    <span class="input-group-addon"><span
                                            class="glyphicon glyphicon-globe"></span></span>
                                </div>

                                <!--------------------------------------separator--------------------------------------------------------------->
                                <br>
                            </div>
                            <div class="col-xs-4">
                                <label>Почтовый индекс</label>
                                <div class="input-group">
                                    <input type="number" class="form-control" name="postcode" value="${address.postcode}" placeholder="Индекс"
                                           required pattern="\d{6}">
                                    <span class="input-group-addon"><span
                                            class="glyphicon glyphicon-globe"></span></span>
                                </div>
                                <br>
                            </div>

                            <div class="col-xs-4">
                                <label>Город</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" name="city" value="${address.city}" placeholder="Город" required>
                                    <span class="input-group-addon"><span
                                            class="glyphicon glyphicon-globe"></span></span>
                                </div>
                                <br>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-4">
                                    <label>Улица</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="street" value="${address.streetName}" placeholder="Улица" required>
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-globe"></span></span>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-4">
                                    <label>Дом</label>
                                    <div class="input-group">
                                        <input type="number" class="form-control" name="house_number" value="${address.houseNumber}" placeholder="Дом"
                                               required pattern="^[1-9]\d*$">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-globe"></span></span>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-4">
                                    <label>Квартира</label>
                                    <div class="input-group">
                                        <input type="number" class="form-control" value="${address.door}" name="float_number"
                                               placeholder="Квартира" required pattern="^[1-9]\d*$">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-globe"></span></span>
                                    </div>
                                    <br>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-4">
                                    <label>Способ оплаты</label>
                                    <div class="input-group">
                                        <select class="form-control" name="payment_type" required id="paymentTypeId">
                                            <option>Картой</option>
                                            <option selected>Наличными</option>
                                        </select>
                                    </div>
                                    <br>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-6">
                                    <label>Способ доставки</label>
                                    <div class="input-group">
                                        <select class="form-control" name="delivery_type" required class="form-control"
                                                id="sel1">
                                            <option>Почтой</option>
                                            <option selected>Курьером</option>
                                            <option>Самовывоз</option>
                                        </select>
                                    </div>
                                </div>
                                <br>
                            </div>
                            <div class="row col-md-12"></div>
                            <div class="form-group">
                                <input type="submit" form="order" name="submit" id="submit" value="Оформить заказ!"
                                       class="btn btn-success center-block">
                            </div>

                        </form>
                    </div><!---modal-body--->
                </div>
            </div>
        </div>
        <script>
            function acall(){
                var data = {
                    paymentType:  document.orderform.elements['payment_type'].value,
                    deliveryType: document.orderform.elements['delivery_type'].value,
                    addressEntity : {
                        country: document.orderform.elements['country'].value,
                        city: document.orderform.elements['city'].value,
                        postcode: document.orderform.elements['postcode'].value,
                        streetName: document.orderform.elements['street'].value,
                        houseNumber: document.orderform.elements['house_number'].value,
                        door: document.orderform.elements['float_number'].value
                    }
                };
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/user/order/",
                    data: JSON.stringify(data),
                    dataType: "json",
                    contentType: "application/json",
                    mimeType: 'application/json',
                    success: function () {
                        var url = "${pageContext.request.contextPath}";
                        window.location.href = url;
                    }
                });
            }
        </script>
    </jsp:body>
</t:genericpage>
