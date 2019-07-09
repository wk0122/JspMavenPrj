
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <meta charset="utf-8">
</head>
<body>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>基本模板</title>
    <!-- 引入bootstrap.min.css -->
    <link rel="stylesheet" href="${path}/plugins/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">

</head>

<body>
<div class="container">
    <div id="outer">
        <form id="loginForm" action="${path}/user/checklogin" class="form-horizontal" role="form">
            <fieldset>
                <legend>
                    <h3>用户登录入口</h3>
                </legend>
                <div class="form-group has-feedback">
                    <label  class="col-md-2 control-label">手机号</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="phone" name="phone" placeholder="请输入名字">
                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        <%--<label class="btn-danger"><span class="username_title_right" id="uspan">用户名不能存在!</span></label>--%>
                    </div>
                </div>
                <div class="form-group has-feedback">
                    <label class="col-md-2 control-label">手机验证码</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" name="code" id="code" placeholder="请输入验证码">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        <%--<label class="btn-danger"><span class="password_title_right" id="pspan">密码错误!</span></label>--%>
                    </div>
                    <div class="col-md-2">
                        <button type="button" class="btn btn-danger" id="sms">发送验证码</button>
                        <c:if test="${param.error==1}">
                            <span>验证码是错误的</span>
                        </c:if>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox">请记住我
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" id="login_btn" class="btn btn-default">登录</button>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</div>

<script src="${path}/plugins/jquery/jquery.min.js"></script>

<script src="${path}/plugins/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script>
    $(function () {
        $("#sms").click(function () {
//            $.get("/JspStudent/user/logincl?phone="+$("#phone").val());

        })
    })
</script>
</body>
</html>
