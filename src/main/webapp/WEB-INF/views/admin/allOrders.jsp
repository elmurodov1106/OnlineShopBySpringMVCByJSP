<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Msi Laptop
  Date: 5/10/2023
  Time: 9:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="../styles.css">
  <title>All Orders</title>
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
<body  style="background-color: slategray">

<div >
  <table  border="1">
    <thead>
    <th> Id</th>
    <th> Seller Name</th>
    <th> Product Amount</th>
    <th> Status</th>
    <th> Product Id</th>
    <th> Owner Id</th>
    <th> Created Date</th>
    <th> Updated Date</th>
    </thead>
    <tbody>
    <jsp:useBean id="AllOrders" scope="request" type="java.util.List<uz.g22.entity.order.OrderEntity>"/>
    <c:forEach items="${AllOrders}" var="order">
      <tr>
        <td>${order.id}</td>
        <td>${order.user.name}</td>
        <td>${order.amount}</td>
        <td>${order.status}</td>
        <td>${order.product.id}</td>
        <td>${order.user.id}</td>
        <td>${order.created}</td>
        <td>${order.created}</td>

      </tr>
    </c:forEach>
    </tbody>
  </table>
  <%----%>
  <div>
    <form action="/menu">
      <input type="hidden" name="userId" value="${userId}">
      <button>Menu</button>
    </form>

  </div>
</div>
</body>
</html>
