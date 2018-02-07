<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/15/2017
  Time: 6:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>

    <div class="container">

        <table class="table table-hover">
            <thead>
            <tr>
                <th>clothes name</th>
                <th>image</th>
                <th>brand</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    ${clothes.clothesName}
                </td>
                <td>
                    ${clothes.brand}
                </td>
                <td>
                    <img src="${clothes.pathImage}" alt="${clothes.clothesName}" height="192px" width="150px">
                </td>
                <td>
                    <c:forEach items="${clothes.brand}" var="brand">
                        ${brand.brandName} <br>
                    </c:forEach>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>