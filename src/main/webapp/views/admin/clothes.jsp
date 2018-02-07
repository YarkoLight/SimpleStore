<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container">

    <div class="panel">
        <sf:form modelAttribute="clothes" action="/clothes?${_csrf.parameterName}=${_csrf.token}"
                 method="post" enctype="multipart/form-data">
            <div style="display: flex; justify-content: space-around ">

                <div class="form-group">
                    <sf:input path="clothesName" type="text" class="form-control" id="exampleInputEmail3"
                              placeholder="clothes name"/>
                    <input type="file" name="image" class="form-control">
                </div>
                <div class="form-group">
                    <select multiple name="brandIds" type="text" class="form-control" id="exampleInputEmail3">
                        <c:forEach var="ingredient" items="${brand}">
                            <option value="${brand.id}">${brand.brandName}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <button class="btn btn-default">save brand</button>
                </div>
            </div>
        </sf:form>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>name</th>
                <th>image</th>
                <th>brand</th>
                <th>delete</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="clothes" items="${clothes}">
                <tr>
                    <td>
                            ${clothes.clothesName}
                    </td>
                    <td>
                        <img src="${clothes.pathImage}" alt="${clothes.clothesName}" height="192px" width="150px">
                    </td>
                    <td>
                            ${clothes.brand}
                    </td>
                    <td>
                        <c:forEach items="${clothes.brand}" var="brand">
                            ${brand.brandName} <br>
                        </c:forEach>
                    </td>

                    <td>
                        <a href="deleteDrink/${clothes.id}">delete</a>
                    </td>
                    <td>
                        <a href="updateDrink/${clothes.id}">update</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>