<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 04.09.2016
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE><html><head>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet">
<style>
    .post-content {
        bottom: 40px;
        left: 100px;
        position: absolute;
    }
</style>
<t:genericpage>
    <jsp:attribute name="header">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <h1>Товары</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div class="row ">
                <div class="col-md-10">
                    <c:forEach items="${products}" var="item">
                        <div class="col-xs-4 col-md-4" style="height:200px;">
                            <div class="div-border">
                                <form action="${pageContext.request.contextPath}/product/getProductItem" method="GET">
                                    <input type="hidden" name="name" value="${item.name}">
                                    <input type="hidden" name="weight" value="${item.weight}">
                                    <input type="hidden" name="volume" value="${item.volume}">
                                    <input type="hidden" name="amount" value="${item.amount}">
                                    <input type="hidden" name="category" value="${item.category.category}">
                                    <input type="hidden" name="price" value="${item.price}">
                                    <input type="hidden" name="imgPath" value="${item.imagePath}">
                                    <input type="hidden" name="id" value="${item.id}">
                                    <input type="image"
                                           src="${pageContext.request.contextPath}/images/${item.imagePath}"
                                           alt="picture not found"
                                           class="img-rounded"
                                           width="100%"
                                           height="80%">
                                    <h4 class="text-center">${item.name}</h4>
                                    <h5 class="text-center post-content">Цена: ${item.price}</h5>
                                </form>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="text-center col-md-12">
                        <ul class="pagination">
                            <li <c:if test="${pageNumber <=1 }"> style="display:none" class="disabled" </c:if>><a
                                    href=${pageContext.request.contextPath}/product/getProducts/${pageNumber-1}/6/${minPrice}/${maxPrice}><<</a>
                            </li>
                            <c:forEach var="i" begin="1" end="${numberOfPages}">
                                <%--<li><a href="#">&laquo;</a></li>--%>
                                <li <c:if test="${i eq pageNumber}">class="active"</c:if>><a
                                        href="${pageContext.request.contextPath}/product/getProducts/${i}/6/${minPrice}/${maxPrice}"><c:out
                                        value="${i}"/></a></li>
                                <%--<li><a href="#">&raquo;</a></li>--%>
                            </c:forEach>
                            <li <c:if test="${pageNumber == numberOfPages}"> style="display:none" </c:if>><a
                                    href=${pageContext.request.contextPath}/product/getProducts/${pageNumber+1}/6/${minPrice}/${maxPrice}>>></a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-2">
                    <label>Цена:</label>
                    <div class="brd">
                        <form id="updateProductByPriceRange"  name = "updateProductByPriceRange" action="javascript:void(null);" onsubmit="acall()"
                              method="get">
                            <div class="form-group">
                                <div class="input-group">
                                    <label for="minPriceId">От:</label>
                                    <input type="text" class="form-control" name="minPrice" value="${minPrice}" id="minPriceId" required
                                           pattern="^[1-9]\d*$">
                                </div>
                                <div class="input-group">
                                    <label for="maxPriceId">До:</label>
                                    <input type="text" class="form-control" name="maxPrice"  value="${maxPrice}" id="maxPriceId" required
                                           pattern="^[1-9]\d*$">
                                </div>
                            </div>
                            <div class="input-group center-block">
                                <input type="hidden" name="operation" value="updateProductsByPriceRange">
                                <input type="submit" id="updateProductButton" style="margin-top: 10px"
                                       class="btn btn-primary center-block"
                                       value="Показать">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        </div>
        <script>
            function acall() {
                var data = {
                    minPrice: document.updateProductByPriceRange.elements['minPrice'].value,
                    maxPrice: document.updateProductByPriceRange.elements['maxPrice'].value,
                };
                var str = "${pageContext.request.contextPath}/product/getProducts/${pageNumber}/6/"+data.minPrice+"/"+data.maxPrice;
                alert(str);
                $("#updateProductByPriceRange").attr("action", str);
            }
        </script>
    </jsp:body>
</t:genericpage>
</head>
</html>
