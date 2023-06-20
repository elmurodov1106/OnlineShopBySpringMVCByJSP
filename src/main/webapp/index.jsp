<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <style>
        div {
            margin-left: 41%;
            margin-top: 15%;
        }

        button {
            display: inline-block;
            padding: 10px 40px;
            margin-bottom: 10%;
            border: none;
            border-radius: 15px;
            font-size: 16px;
            cursor: pointer;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
        }
        button:hover{
            background-color: skyblue;
        }
        body{
            font-family: Arial, sans-serif;
            background-color: darkcyan;
        }
    </style>
</head>
<body>

<div>
    <a href="/sign-in">
        <button><b>Sign in</b></button>
    </a><br>
    <a href="/sign-up">
        <button><b>Sign up</b></button>
    </a>
</div>
</body>
</html>