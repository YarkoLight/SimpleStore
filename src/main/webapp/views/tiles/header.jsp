<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 5/31/2017
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<link rel="stylesheet" href="/css/header.css">--%>
<<nav class="navbar navbar-default">
<div class="container-fluid">
    <header class="header" role="banner">
        <nav>
            <ul class="nav navbar-nav">
                <li class="active">
                    <a href="/"><spring:message code="label.home"/></a>
                </li>
                <li>
                    <a href="/random"><spring:message code="label.random"/></a>
                </li>
                <sec:authorize access="hasAnyRole('ROLE_USER')">
                    <li class="active">
                        <a href="/profile"><spring:message code="label.profile"/></a>
                    </li>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <li>
                        <a href="/signUp"><spring:message code="label.sign_up"/></a>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li>
                        <a href="/country"><spring:message code="label.countries"/></a>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_USER')">
                    <li>
                        <a href="/history"><spring:message code="label.history"/></a>
                    </li>
                </sec:authorize>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false">
                        <spring:message code="label.lang"/> <span class="caret"></span>
                        <ul class="dropdown-menu">
                            <li><a href="?lang=ua">ua</a></li>
                            <li><a href="?lang=en">en</a></li>
                        </ul>
                    </a>
                </li>
                <sec:authorize access="isAuthenticated()">
                    <li>
                        <form:form action="/logout" method="post" cssStyle="float: right">
                            <button class="btn btn-default"><spring:message code="label.logout"/></button>
                        </form:form>
                    </li>
                </sec:authorize>
            </ul>
        </nav>
    </header>
</div>
</nav>