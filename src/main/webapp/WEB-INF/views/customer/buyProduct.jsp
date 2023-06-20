<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Msi Laptop
  Date: 5/9/2023
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <title>Buy Product</title>
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
<form action="/buy-product/${userId}" method="post" >
  <input type="hidden" name="productId" value="${productId}"/>
  <label><b>Product amount:</b>
    <input style="margin-left: 22px" type="number" required placeholder="amount" min="1"  name="amount"><br>
  </label><br>
<%--  <label class="form-label"> Choose Card </label>--%>
<%--  <label>--%>
<%--    <select class="form-input" name="card">--%>
<%--      <jsp:useBean id="cards" scope="request" type="java.util.List<uz.g22.entity.card.CardEntity>"/>--%>
<%--      <c:forEach items="${cards}" var="card">--%>
<%--        <option class="form-input" value="cardNumber">${card.number}</option>--%>
<%--      </c:forEach>--%>
<%--    </select>--%>
<%--  </label>--%>
  <%--  <label><b>Card number:</b>--%>
<%--    <input style="margin-left: 22px" type="text" required placeholder="card number" min="1"  name="number"><br>--%>
<%--  </label><br>--%>
  <button>Buy</button>
</form>
<div>
  <h3 ><c:if test="${message != null}">${message}</c:if></h3>
</div>
</body>
</html>
