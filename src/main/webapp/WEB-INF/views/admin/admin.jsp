
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <style>
        div {
            margin-left: 1%;
            margin-top: 11%;
        }

        button {
            padding: 14px 20px;
            margin: 30px 350px;
            width: 40%;
            border-radius: 20px;
            background-color: #54575a;
            color: #fff;
            border: none;
            font-size: 16px;
            cursor: pointer;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
        }
    </style>
</head>
<body style="background-color: lightslategray">

<div>
    <a href="/all-users-admin/${user.id}">
        <button><b>All Users List</b></button>
    </a><br>
    <a href="/all-products-admin/${user.id}">
        <button><b>All Products List</b></button>
    </a>
    <a href="/all-orders/${user.id}">
        <button><b>All Orders List</b></button>
    </a>

    <a href="/my-orders/${user.id}">
        <button><b>My Orders List</b></button>
    </a>

    <a href="/unblock-users/${user.id}">
        <button><b>Block Users List</b></button>
    </a>
    <a href="/add-card/${user.id}">
        <button><b>Add Card</b></button>
    </a>

    <a href="/add-card/${user.id}">
        <button><b>Add Card</b></button>
    </a>
    <a href="/my-cards/${user.id}">
        <button><b>My Cards</b></button>
    </a>

    <a href="/fill-balance/${user.id}">
        <button><b>Fill Balance</b></button>
    </a>
</div>
</body>
</html>
