<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/8/2017
  Time: 2:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">

    <table class="table table-hover">
        <thead>
        <tr>
            <th>order date</th>
            <th>clothes</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${user.orders}">
            <tr>
                <td>
                        ${order.localDateTime}
                </td>
                <td>
                    <c:forEach items="${order.clothes}" var="clothes">
                        ${clothes.clothesName} <br>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>