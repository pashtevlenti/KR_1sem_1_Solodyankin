<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Подробная информация</title>
    <meta charset="utf-8"/>

    <style type="text/css">
        .header {
            display:flex;
            justify-content:center;
        }
    </style>
</head>


<h1>Заказ ${order.getId()}</h1>
<h2>Блюда ${order.getDishList()}</h2>
<h3>Номер стола ${order.getTableNumber()}</h3>
<h4>Официант ${order.getWaiterName()}</h4>

</html>