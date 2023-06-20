<%--
  Created by IntelliJ IDEA.
  User: Msi Laptop
  Date: 5/7/2023
  Time: 12:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Seller</title>
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
      background-color: #3b3e40;
      color: #fff;
      border: none;
      font-size: 16px;
      cursor: pointer;
      box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
    }

  </style>
</head>
<body style="background-color: darkgoldenrod">

<div>
  <a href="/add-product/${user.id}">
    <button><b>Add Product</b></button>
  </a><br>
  <a href="/all-product/${user.id}">
    <button><b>My Products</b></button>
  </a>
  <a href="/my-history/${userId}">
    <button><b>My History</b></button>
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
