<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 12.09.2016
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="${pageContext.request.contextPath}/css/error.css" rel="stylesheet">
<div class="error-404">
    <div class="error-code m-b-10 m-t-20">404 <i class="fa fa-warning"></i></div>
    <h2 class="font-bold">Ой, 404! Страница не найдена.</h2>

    <div class="error-desc">
        К сожалению, запрашиваемая вами страница не найдена или не существует <br/>
        <div><br/>
            <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary"><span
                    class="glyphicon glyphicon-home"></span> Возврат на главную</a>
        </div>
    </div>
</div>
