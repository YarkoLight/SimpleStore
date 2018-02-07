<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>

<div class="container">

    <div class="panel">
        <form:form modelAttribute="brand" method="post">
            <div style="display: flex; justify-content: space-around ">

                <div class="form-group">
                    <label class="sr-only" for="exampleInputEmail3">Email address</label>
                    <form:input path="brandName" type="text" class="form-control" id="exampleInputEmail3"
                                placeholder="brand name"/>
                </div>
                <div class="form-group">
                    <button class="btn btn-default">save brand</button>
                </div>
            </div>
        </form:form>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>brand name</th>
                <th>delete</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="brand" items="${brands.content}">
                <tr>
                    <td>
                            ${brand.brandName}
                    </td>
                    <td>
                        <a href="deleteBrand/${brand.id}">delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div style="display: flex; justify-content: center; margin-left: 10%">

            <div class="col-md-12 col-xs-12">
                <div class="row">
                    <div class="col-md-2 col-xs-6">
                        <div class="dropdown">
                            <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span
                                    class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <custom:sort innerHtml="Name asc" paramValue="brandName"/>
                                <custom:sort innerHtml="Name desc" paramValue="brandName,desc"/>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-6 col-xs-12 text-center">
                        <custom:pageable page="${brands}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
                    </div>
                    <div class="col-md-2 col-xs-6">
                        <custom:size posibleSizes="1,2,5,10" size="${brands.size}"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--<a href="/ingredient?page=${ingredients.number}&size=${ingredients.size}">previous</a>--%>
<%--<a href="/ingredient?page=${ingredients.number+ 2}&size=${ingredients.size}">next</a>--%>