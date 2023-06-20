<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Msi Laptop
  Date: 5/11/2023
  Time: 7:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="../styles.css">
  <title>User List</title>
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
    <th> Name</th>
    <th> Email</th>
    <th> Password</th>
    <th> Balance</th>
    <th> Role</th>
    <th> Created Date</th>
    <th> Updated Date</th>
    <th> Block </th>


    </thead>
    <tbody>
    <jsp:useBean id="allUsers" scope="request" type="java.util.List<uz.g22.entity.product.Product>"/>
    <c:forEach items="${allUsers}" var="user">
    <tr>
      <td>${user.id}</td>
      <td>${user.name}</td>
      <td>${user.email}</td>
      <td>${user.password}</td>
      <td>${user.balance}</td>
      <td>${user.role}</td>
      <td>${user.created}</td>
      <td>${user.updated}</td>
      <td>
        <form action="/block-user/${user.id}">
<%--          <input type="hidden" name="productId" value="${product.id}">--%>
          <button style="width: 100%">
            Block
          </button>
        </form>
      </td>
<%--      <td>--%>
<%--        <form action="/unblock-user/${user.id}">--%>
<%--            &lt;%&ndash;          <input type="hidden" name="productId" value="${product.id}">&ndash;%&gt;--%>
<%--          <button style="width: 100%">--%>
<%--            UnBlock--%>
<%--          </button>--%>
<%--        </form>--%>
<%--      </td>--%>


      </c:forEach>
    </tbody>
  </table>
  <div>
    <form action="/menu">
      <input type="hidden" name="userId" value="${userId}">
      <button>Menu</button>
    </form>

  </div>
  <div>
    <form action="/sign-in">
      <input type="hidden" name="userId" value="${userId}">
      <button>Sign In</button>
    </form>

  </div>
</div>
<%--<div>--%>
<%--  <h4><c:if test="${message != null}">${message}</c:if></h4>--%>
<%--</div>--%>
</body>
</html>

