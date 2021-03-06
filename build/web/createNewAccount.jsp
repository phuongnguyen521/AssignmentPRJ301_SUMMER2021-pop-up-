<%-- 
    Document   : createNewAccount
    Created on : Jul 3, 2021, 10:04:09 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/account.css" rel="stylesheet" type="text/css"/>
        <title>Create New Account</title>
    </head>
    <body>
        <div class="account_box">
            <h1>Create New Account</h1>
            <c:set var="errors" value="${requestScope.INSERT_ERRORS}" />
            <form action="createAccount" method="POST">
                <p>Username* (6 - 20 chars)</p>
                <input type="text" name="txtUsername" value="${param.txtUsername}" 
                       placeholder="Enter username"/><br/>
                <c:if test="${not empty errors.usernameLengthErr}">
                    <font color="red">
                    ${errors.usernameLengthErr}
                    </font><br/>
                </c:if>
                <c:if test="${not empty errors.usernameIsExisted}">
                    <font color="red">
                    ${errors.usernameIsExisted}
                    </font><br/>
                </c:if>
                <p>Password*(6 - 30 chars)</p> 
                <input type="password" name="txtPassword" value="" 
                       placeholder="Enter password"/><br/>
                <c:if test="${not empty errors.passwordLengthErr}">
                    <font color="red">
                    ${errors.passwordLengthErr}
                    </font><br/>
                </c:if>
                <p>Confirm</p>
                <input type="password" name="txtConfirm" value="" 
                       placeholder="Enter confirm password"/><br/>
                <c:if test="${not empty errors.confirmNotMatch}">
                    <font color="red">
                    ${errors.confirmNotMatch}
                    </font><br/>
                </c:if>
                <p>Full name*(2 - 50 chars)</p>
                <input type="text" name="txtFullname" value="${param.txtFullname}" 
                       placeholder="Enter full name"/><br/>
                <c:if test="${not empty errors.fullnameLengthErr}">
                    <font color="red">
                    ${errors.fullnameLengthErr}
                    </font><br/>
                </c:if>
                <input type="submit" value="Create New Account" name="btAction" />
                <input type="submit" value="Reset" />
            </form>
            <a href="login">Login Page</a><br/>
            <a href="shoppingServlet">Shopping Online</a>
        </div>
    </body>
</html>
