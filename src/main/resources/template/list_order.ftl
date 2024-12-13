<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Cписок заказов</title>
    <meta charset="utf-8"/>

    <style type="text/css">
        .header {
            display:flex;
            justify-content:center;
        }
    </style>
</head>
<body>
<div class="header">
    <h1>Список заказов</h1>
</div>
</body>
<h2>Заказы</h2>


<table>
    <#list orders as order>
        <tr>
            <td><a href="/KR/order?id=${order.getId()}">Заказ #${order.getId()}</a></td>
        </tr>
    </#list>
</table>


<#--<script>-->
<#--    function saveParameter() {-->
<#--        const form = document.getElementById('btn1');-->
<#--        const formData = new FormData(form);-->
<#--        localStorage.setItem('search',formData.get('search'));-->
<#--    }-->
<#--    function handleSecondButtonClick() {-->
<#--        const btn2 = document.getElementById('btn2');-->
<#--        btn2.value = localStorage.getItem('search');-->
<#--    }-->
<#--    function handleThirdButtonClick() {-->
<#--        const btn3 = document.getElementById('btn3');-->
<#--        btn3.value = localStorage.getItem('search');-->
<#--    }-->
<#--</script>-->

</html>