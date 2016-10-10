<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 12.09.2016
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:genericadminpage>
    <jsp:attribute name="header">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <form action="javascript:void(null);" onsubmit="acall()" method="post" id="updateProduct">
                <div class="form-group">
                    <div class="col-xs-6">
                        <label>Название</label>
                        <div class="input-group">
                            <input type="text" class="form-control" name="name" required>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                        <!--------------------------------------separator--------------------------------------------------------------->
                        <hr>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-6">
                        <label>Категория</label>
                        <div class="input-group">
                                <%--<input type="text" class="form-control" name="category" required>--%>
                            <select name="category" required class="form-control">
                                <c:forEach items="${requestScope.categoryList}" var="item">
                                    <option value="${item.id}|${item.category}">
                                            ${item.category}
                                    </option>
                                    <option hidden></option>
                                </c:forEach>
                            </select>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                        <!--------------------------------------separator--------------------------------------------------------------->
                        <hr>
                    </div>
                </div>
                <!--------------------------------------separator--------------------------------------------------------------->
                <hr>
                <div class="form-group">
                    <div class="col-xs-3">
                        <label>Цена</label>
                        <div class="input-group">
                            <input type="text" class="form-control" name="price" required>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                        <!--------------------------------------separator--------------------------------------------------------------->
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-xs-3">
                        <label>Вес</label>
                        <div class="input-group">
                            <input type="text" class="form-control" name="weight" required>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-3">
                        <label>Количество</label>
                        <div class="input-group">
                            <input type="text" class="form-control" name="amount" required>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-3">
                        <label>Количество скоростей</label>
                        <div class="input-group">
                            <input type="text" class="form-control" name="volume" required>
                                <span class="input-group-addon"><span
                                        class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                    </div>
                </div>

                <div class="col-xs-12">
                    <br>
                    <label>Путь к файлу</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="img_path" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                    <br>
                </div>
                <div class="form-group">
                    <input type="submit" name="submit" id="submitUpdate" value="Сохранить изменения"
                           class="btn btn-success center-block">
                </div>
            </form>
        </div>
        <script>
            function acall() {
                //e.preventDefault(); // avoid to execute the actual submit of the form.z
                var url = "${pageContext.request.contextPath}/admin/productItem"; // the script where you handle the form input.
                var category = $("select[name=category]").val().split('|');
                var data = {
                    name: $("input[name=name]").val(),
                    price: $("input[name=price]").val(),
                    category: {
                        id: category[0], category: category[1],
                    },
                    weight: $("input[name=weight]").val(),
                    volume: $("input[name=volume]").val(),
                    amount: $("input[name=amount]").val(),
                    imagePath: $("input[name=img_path]").val()
                };
                $.ajax({
                    type: "POST",
                    url: url,
                    data: JSON.stringify(data), // serializes the form's elements.
                    dataType: "json",
                    contentType: "application/json",
                    mimeType: 'application/json',
                    success: function (data) {
                        alert("Данные успешно добавлены!"); // show response from the  script.
                        window.location.href = data.redirectUrl;
                    }

                });
            }

            //})
        </script>
    </jsp:body>
</t:genericadminpage>
