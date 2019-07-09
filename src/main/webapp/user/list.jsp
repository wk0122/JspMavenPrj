<%--
  Created by IntelliJ IDEA.
  User: js
  Date: 2019/6/12
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="${path}/plugins/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${path}/plugins/layui/css/layui.css">
</head>
<body>

<%@include file="../common/nav.jsp"%>

<%@include file="page.jsp"%>

<script src="${path}/plugins/jquery/jquery.min.js"></script>
<script src="${path}/plugins/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<!-- 将所有的模块全部加载 -->
<script src="${path}/plugins/layui/layui.all.js"></script>

<script>
    function nextPage(searchName,pageNow) {
        var pageSize=$("#pageSize").val();
        window.location="${path}/user/permission/list?username="+searchName+"&pageNow="+pageNow+"&pageSize="+pageSize;
    }

    function changePageSize(obj) {
        var searchName=$("#searchName").val();
        window.location="${path}/user/permission/list?username="+searchName+"&pageNow=1&pageSize="+obj.value;
    }
</script>
</body>
</html>
