<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign in</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #0b7a0b;
        }

        form {
            margin-left: 10%;
            margin-top: 11%;
        }
        select {
            padding: 8px 20px;
            margin: 20px 2%;
            border-radius: 20px;
            border: none;
            background-color: skyblue;
            font-size: 14px;
            color: #333;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
        }
        input {
            display: block;
            width: 80%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            margin-bottom: 10px;
            font-size: 16px;
            color: #333;
            background-color: #f2f2f2;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
        }

        .container {
            max-width: 400px;
            margin: 50px auto;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            padding: 20px;
        }

        button {
            background-color: #3b3e40;
            color: #fff;
            padding: 10px 20px;
            margin-left: 30%;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
        }
        button:hover {
            background-color: #54575a;
        }
    </style>
</head>
<body>


<div class="container">
    <h2>Sign In</h2>
    <!--/*@thymesVar id="user" type="uz.jk.domain.dto.UserCreateDto"*/-->
    <form action="/sign-in" method="post" >
        <input type="email" required placeholder="email" name="email"><br>
        <input type="password" required placeholder="password" name="password"><br>
<%--      <input type="hidden" name="userId" value="${}">--%>
<%--        <h4>Enter your status example:ADMIN,SELLER,CUSTOMER </h4>--%>
<%--        <input type="text" required placeholder="status" name="role"><br>--%>
<%--        <label ><b>Choose role Type</b>--%>
<%--            <select name="role">--%>
<%--                <option value="CUSTOMER">CUSTOMER</option>--%>
<%--                <option value="SELLER">SELLER</option>--%>
<%--                <option value="ADMIN">ADMIN</option>--%>
<%--            </select>--%>
<%--        </label><br>--%>
        <button>Sign in</button>
    </form>
</div>
<div>
    <h4><c:if test="${message != null}">${message}</c:if></h4>

</div>


</body>
</html>