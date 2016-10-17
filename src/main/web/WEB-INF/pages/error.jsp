<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 12.09.2016
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<link href="${pageContext.request.contextPath}/css/error.css" rel="stylesheet">
<div class="error-404">
    <div class="error-code m-b-10 m-t-20">404 <i class="fa fa-warning"></i></div>
    <h2 class="font-bold">Oops, 404! Page not found.</h2>

    <div class="error-desc">
        Sorry, an error has occured, Requested page not found! <br/>
        <div><br/>
            <a href="${pageContext.request.contextPath}/" class="btn btn-primary"><span
                    class="glyphicon glyphicon-home"></span> home</a>
        </div>
    </div>
</div>
