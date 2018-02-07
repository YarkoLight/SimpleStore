<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/12/2017
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">


    <div class="panel">
        <form:form modelAttribute="country" action="/updateCountry/${country.id}?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
            <div style="display: flex; justify-content: space-around ">

                <div class="form-group">
                    <label class="sr-only" for="exampleInputEmail3">Email address</label>
                        ${nameException}
                    <input name="name" type="text" class="form-control" id="exampleInputEmail3"
                           value="${country.name}" />
                </div>
                <div class="form-group">
                    <input name="image" type="file" class="form-control" required="required"/>
                </div>
                <div class="form-group">
                    <button class="btn btn-default">save updates</button>
                </div>
            </div>
        </form:form>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>name</th>
                <th>image</th>
                <th>update</th>
                <th>delete</th>
            </tr>
            </thead>
            <tbody>

            <tr>
                <td>
                    ${country.name}
                </td>
                <td>
                    <img src="/${country.pathImage}" width="20%" height="20%">
                </td>
                <td>
                    <a href="updateCountry/${country.id}">update</a>
                </td>
                <td>
                    <a href="deleteCountry/${country.id}">delete</a>
                </td>
            </tr>

            </tbody>
        </table>
    </div>
</div>