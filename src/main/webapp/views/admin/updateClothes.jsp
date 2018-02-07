<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/12/2017
  Time: 9:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form action="/updateClothes/${clothes.id}?${_csrf.parameterName}=${_csrf.token}"
           enctype="multipart/form-data" method="post">
    <div class="container">
        <div class="panel">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>name</th>
                    <th>image</th>
                    <th>brand</th>
                    <th>
                        <button class="btn btn-default">save updates</button>
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <input name="clothesName" value="${clothes.clothesName}" class="form-control"/>
                    </td>
                    <td>
                        <input name="image" type="file" class="form-control" required="required">
                    </td>
                    <td>
                        <c:forEach items="${clothes.brand}" var="brand">
                            <input type="checkbox" name="brand" checked="checked" value="${brand.id}">${brand.brandName}<br>
                        </c:forEach>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</form:form>
