<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Add Card</title>
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
<form action="/edit-card/${userId}" METHOD="post" >
    <label><b>Card number:</b>
        <input style="margin-left: 39px" type="text" required placeholder="number" name="number"><br>
    </label><br>
    <label><b>Balance:</b>
        <input type="number" required placeholder="balance" min="1" name="balance"><br>
    </label><br>
    <label><b> Expire date:</b>
        <input style="margin-left: 22px" type="text" required placeholder="expire_date"  name="expire_date"><br>
    </label><br>

    <label style="margin-left: 39px" for="roles">Choose card type:</label>
    <select name="card_type" id="roles">
        <option value="HUMO">HUMO</option>
        <option value="UZCARD">UZCARD</option>
        <option value="MASTERCARD">MASTERCARD</option>
    </select>
    <br><br>
    <button>Add</button>
</form>
</body>
</html>
