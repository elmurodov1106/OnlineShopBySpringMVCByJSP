<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <style>
        form {
            margin-left: 10%;
            margin-top: 11%;
        }

        input {
            display: block;
            width: 82%;
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
        body {
            font-family: Arial, sans-serif;
            background-color: lightyellow;
        }
        button:hover {
            background-color: #54575a;
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
    </style>
</head>
<body>



<div class="container">
    <h2>Sign Up</h2>
    <!--/*@thymesVar id="UserCreateDto" type="uz.jk.domain.dto.UserCreateDto"*/-->
    <form action="/sign-up" method="post" >
        <input type="text" name="name" placeholder="name"><br>
        <input type="email" name="email" placeholder="email" required><br>
        <input type="password" name="password" placeholder="password" required><br>
<%--        <input type="text" name="role" placeholder="STATUS"><br>--%>
<%--    </form>--%>
<%--    <form action="/action_page.php">--%>
        <label for="roles">Choose role:</label>
        <select name="role" id="roles">
            <option value="SELLER">SELLER</option>
            <option value="ADMIN">ADMIN</option>
            <option value="CUSTOMER">CUSTOMER</option>
        </select>
        <br><br>
        <button>Sign up</button>
<%--        <input type="submit" value="Submit">--%>
    </form>
</div>
</body>
</html>
