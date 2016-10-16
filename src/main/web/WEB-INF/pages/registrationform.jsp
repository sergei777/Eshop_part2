<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 02.09.2016
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"  language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:genericpage>
    <jsp:attribute name="header">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <h1>Регистрация</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div id="login-overlay" class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title text-center" id="myModalLabel">Регистрация нового пользователя</h4>
                    </div>
                    <div class="modal-body">
                        <form enctype="application/json" id="registerForm" action="javascript:void(null);" onsubmit="acall()" method="post" name = "registrationform" >
                        <%--<form enctype='application/json' id="registerForm" action="${pageContext.request.contextPath}/registrationform" method="POST">--%>
                            <!---form--->
                            <div class="form-group">
                                <%--<c:if test="${not empty error}">--%>
                                    <div  id="email-error" class="alert alert-danger" style="display: none;">
                                        <strong>Ошибка!</strong> Пользователь с таким email уже существует!
                                    </div>
                                    <div  id="username-error" class="alert alert-danger" style="display: none;">
                                        <strong>Ошибка!</strong> Пользователь с таким логином уже существует!
                                    </div>
                                <%--</c:if>--%>
                                <!---input width--->
                                <div class="col-xs-6">
                                    <label>Имя</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="firstName"
                                               placeholder="Введите имя пользователя" required >
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-asterisk"></span></span>
                                    </div>
                                    <br>
                                    <label>Логин</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="username"
                                               placeholder="Введите логин" required >
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-asterisk"></span></span>
                                    </div>
                                    <!--------------------------------------separator--------------------------------------------------------------->
                                    <hr>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label>Фамилия</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="secondName"
                                               placeholder="Введите фамилию" required >
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-asterisk"></span></span>
                                    </div>
                                    <br>
                                    <label>Пароль</label>
                                    <div class="input-group">
                                        <input type="password" class="form-control" name="password"
                                               placeholder="Введите пароль" required >
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-asterisk"></span></span>
                                    </div>
                                    <!--------------------------------------separator--------------------------------------------------------------->
                                    <hr>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <label>Дата рождения</label>
                                    <div class="input-group">
                                        <input type="date" class="form-control" id="dateInput" name="birthDate"
                                               placeholder="Введите дату рождения в формате dd-mm-yyyy" required pattern="^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\d\d$">
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-asterisk"></span></span>
                                    </div>
                                    <!----------------------------break------------------------------------------------------------->
                                    <br>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <label>E-mail</label>
                                    <div class="input-group">
                                        <input type="email" class="form-control" name="email"
                                               placeholder="Введите e-mail" required pattern="\S+@\S+">
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-asterisk"></span></span>
                                    </div>
                                    <!----------------------------break------------------------------------------------------------->
                                    <br>
                                </div>
                            </div>
                            <div class="modal-header">
                                <h4 class="modal-title text-center" id="myAdditionalInformationModalLabel">Контактная
                                    информация</h4>
                            </div>
                            <!----------------------------break------------------------------------------------------------->
                            <br>
                            <div class="col-xs-6">
                                <label>Страна</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" name="country" placeholder="Страна">
                                    <span class="input-group-addon"><span
                                            class="glyphicon glyphicon-globe"></span></span>
                                </div>
                                <br>
                                <label>Почтовый код</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" name="postcode"
                                           placeholder="Введите почтовый код" pattern="\d{6}">
                                    <span class="input-group-addon"><span
                                            class="glyphicon glyphicon-globe"></span></span>
                                </div>
                                <!--------------------------------------separator--------------------------------------------------------------->
                                <br>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label>Город</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="city" placeholder="Город">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-globe"></span></span>
                                    </div>
                                    <br>
                                    <label>Улица</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="streetName"
                                               placeholder="Введите название улицы">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-globe"></span></span>
                                    </div>
                                    <!--------------------------------------separator--------------------------------------------------------------->
                                    <br>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label>Дом</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="houseNumber"
                                               placeholder="Введите номер дома" pattern="^[1-9]\d*$">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-globe"></span></span>
                                    </div>
                                    <hr>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label>Квартира</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="door"
                                               placeholder="Введите номер квартиры" pattern="^[1-9]\d*$">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-globe"></span></span>
                                    </div>
                                    <hr>
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="submit" form="registerForm" name="submit" id="submit"
                                       value="Зарегистироваться!" class="btn btn-success center-block">
                            </div>
                        </form>
                    </div><!---modal-body--->
                </div>
            </div>
            <script>
                function acall(){
                    $("#email-error").hide();
                    $("#username-error").hide();
                    var data = {
                        firstName : document.registrationform.elements['firstName'].value,
                        secondName: document.registrationform.elements['secondName'].value,
                        email: document.registrationform.elements['email'].value,
                        username:document.registrationform.elements['username'].value,
                        password:document.registrationform.elements['password'].value,
                        birthDate: Date.parse(document.registrationform.elements['birthDate'].value),
                        addressEntity : {
                            country : document.registrationform.elements['country'].value,
                            city : document.registrationform.elements['city'].value,
                            postcode : document.registrationform.elements['postcode'].value,
                            streetName : document.registrationform.elements['streetName'].value,
                            houseNumber : document.registrationform.elements['houseNumber'].value,
                            door : document.registrationform.elements['door'].value
                        }
                    };
                    $.ajax({
                        type: "POST",
                        url: "${pageContext.request.contextPath}/registrationform/",
                        data: JSON.stringify(data),
                        dataType: "json",
                        contentType: "application/json",
                        mimeType: 'application/json',
                        success: function (data) {
                            if(data.error) {
                                if(data.error == "email") $("#email-error").show();
                                if (data.error = "username")  $("#username-error").show();
                            }
                            else window.location.href = data.redirectUrl;
                        }
                    });
                }
            </script>
        </div>
    </jsp:body>
</t:genericpage>
