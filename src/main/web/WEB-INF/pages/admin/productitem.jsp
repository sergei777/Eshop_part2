<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 12.09.2016
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericadminpage>
    <jsp:attribute name="header">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $(document).on('click', '#submitUpdate', function (e) {
                    e.preventDefault(); // avoid to execute the actual submit of the form.z
                var url = "/product-list"; // the script where you handle the form input.
                var smt = $("#updateProduct");
                $.ajax({
                    type: "POST",
                    url: url,
                    data: smt.serialize(), // serializes the form's elements.
                    success: function()
                    {
                        alert("Данные успешно изменены!"); // show response from the  script.
                    }
                });
            })
            });
        </script>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <form method="post" id="updateProduct">
                <div class="form-group">
                    <div class="col-xs-6">
                        <label>Название</label>
                        <div class="input-group">
                            <input type="text" class="form-control" name="name" value="${productItem.name}" required>
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
                            <input type="text" class="form-control" name="category" value="${productItem.category}" required>
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
                            <input type="text" class="form-control" name="price" value="${productItem.price}" required>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                        <!--------------------------------------separator--------------------------------------------------------------->
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-xs-3">
                        <label>Вес</label>
                        <div class="input-group">
                            <input type="text" class="form-control" name="weight" value="${productItem.weight}"
                                   required>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-3">
                        <label>Количество</label>
                        <div class="input-group">
                            <input type="text" class="form-control" name="amount" value="${productItem.amount}"
                                   required>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                    </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-3">
                            <label>Количество скоростей</label>
                            <div class="input-group">
                                <input type="text" class="form-control" name="volume" value="${productItem.volume}"
                                       required>
                                <span class="input-group-addon"><span
                                        class="glyphicon glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                    </div>

                    <div class="col-xs-12">
                        <br>
                        <label>Путь к файлу</label>
                        <div class="input-group">
                            <input type="text" class="form-control" name="img_path" value="${productItem.imagePath}"
                                   required>
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
    </jsp:body>
</t:genericadminpage>
