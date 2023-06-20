<%--
  Created by IntelliJ IDEA.
  User: Msi Laptop
  Date: 5/8/2023
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <title>Update Product</title>
  <style>
    table {
      border-collapse: collapse;
      width: 100%;
      color: #333;
      font-family: Arial, sans-serif;
      font-size: 14px;
      text-align: left;
      background-color: #f2f2f2;
    }
    table th {
      background-color: #3b3e40;
      color: #fff;
      padding: 8px;
      text-transform: uppercase;
      letter-spacing: 2px;
      border: 1px solid #ddd;
    }
    table td {
      padding: 8px;
      border: 1px solid #ddd;
    }

    select {
      padding: 10px 30px;
      margin: 1px 10px;
      border-radius: 15px;
      border: none;
      background-color: #f2f2f2;
      font-size: 16px;
      color: #333;
      box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
    }

    button {
      background-color: chocolate;
      color: #fff;
      padding: 10px 20px;
      border: none;
      border-radius: 15px;
      font-size: 16px;
      cursor: pointer;
      box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
    }

    input {
      padding: 10px 30px;
      border-radius: 15px;
      border: none;
      background-color: #f2f2f2;
      font-size: 16px;
      color: #333;
      box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
    }
  </style>
</head>
<body style="background-color: slategray">

<!--/*@thymesVar id="product" type="uz.jk.domain.dto.ProductCreateDto"*/-->
<form action="/update-product/${productId}" method="post">
  <input type="hidden" name="userId" value="${userId}"/>

  <label><b>Product name:</b>
    <input style="margin-left: 39px" type="text" required placeholder="name" name="name"><br>
  </label><br>
  <label><b>Product description:</b>
    <input type="text" required placeholder="description" name="description"><br>
  </label><br>
  <label><b>Product price:</b>
    <input style="margin-left: 22px" type="number" required placeholder="price" min="1" name="price"><br>
  </label><br>

  <label><b>Product amount:</b>
    <input style="margin-left: 22px" type="number" required placeholder="amount" min="1" name="amount"><br>
  </label><br>

  <label style="margin-left: 22px"  for="roles">Choose category:</label>
  <select name="category" id="roles">
    <option value="LAPTOP">LAPTOP</option>
    <option value="PHONE">PHONE</option>
    <option value="GADGET">GADGET</option>
  </select>
  <br><br>
  <button>Update</button>
</form>
<br>
<br>

</body>
</html>

