<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<link rel="stylesheet" type="text/css" href="/css/signUp.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/js/signUp.js"></script>

<div style="text-align: center">${exception}</div>

<div class="form-wrap">
    <div class="tabs">
        <h3 class="signup-tab"><a class="active" href="#signup-tab-content">Sign Up</a></h3>
        <h3 class="login-tab"><a href="#login-tab-content">Login</a></h3>
    </div><!--.tabs-->

    <div class="tabs-content">
        <div id="signup-tab-content" class="active">
            <form:form modelAttribute="user" class="signup-form" method="post">
                <h3 style="text-align: center;color: red">${usernameException}</h3>
                <form:input path="name" type="text" class="input" id="user_name" autocomplete="off"
                            placeholder="Username"/>
                <h3 style="text-align: center;color: red">${emailException}</h3>
                <form:input path="email" type="text" class="input" id="user_email" autocomplete="off"
                            placeholder="Email"/>
                <h3 style="text-align: center;color: red">${passwordException}</h3>
                <form:input path="password" type="password" class="input" id="user_pass" autocomplete="off"
                            placeholder="Password"/>
                <input type="submit" class="button" value="Sign Up">
            </form:form>
        </div>

        <div id="login-tab-content">
            <form:form class="login-form" action="/login" method="post">
                <input name="username" type="text" class="input" id="user_login" autocomplete="off" placeholder="Username">
                <input name="password" type="password" class="input" id="user_pass" autocomplete="off" placeholder="Password">

                <input type="submit" class="button" value="Login">
            </form:form>
        </div
    </div>
</div>