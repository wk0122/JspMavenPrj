<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: js
  Date: 2019/6/13
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="${path}/plugins/bootstrap-3.3.7-dist/css/bootstrap.min.css">
</head>
<body>

<%@include file="../common/nav.jsp"%>


<%--存放page.jsp页面的容器--%>
<div id="pageContent">


</div>


<span><%= new Date()%></span>
<script type="text/javascript" src="${path}/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${path}/plugins/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>


<script>
<%--//将page.jsp塞到容器中--%>
    $(function () {
        $("#pageContent").load("${path}/user/permission/list")
    });

    function nextPage(searchName,pageNow) {
    var pageSize=$("#pageSize").val();
    $("#pageContent").load("${path}/user/permission/list",{"username":searchName,"pageNow":pageNow,"pageSize":pageSize})
    }

    function changePageSize(obj) {
    var searchName=$("#searchName").val();
    $("#pageContent").load("${path}/user/permission/list",{"username":searchName,"pageNow":"1","pageSize":obj.value})
    }

    function search() {
        var searchName=$("#searchName").val();
        $("#pageContent").load("${path}/user/permission/list",{"username":searchName})
    }
</script>

</body>
</html>
