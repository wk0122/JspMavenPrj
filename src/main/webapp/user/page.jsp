<%--
  Created by IntelliJ IDEA.
  User: js
  Date: 2019/6/13
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!--搜索框-->
<div class="container-fluid">
    <div>
        <form action="${path}/user/permission/list" method="get" class="bs-example bs-example-form" role="form">
            <div class="row">
                <%--<div class="col-md-3">--%>
                    <%--<div class="input-group">--%>
                        <%--<input type="text" name="username" id="searchName" value="${searchName}" placeholder="根据用户名模糊查询" class="form-control">--%>
                        <%--<span class="input-group-btn">--%>
                <%--<button class="btn btn-info" type="submit">查询</button>--%>
                <%--</span>--%>
                    <%--</div><!-- /input-group -->--%>
                <%--</div><!-- /.col-lg-6 -->--%>

                <div class="col-md-3">
                    <div class="input-group">
                        <input type="text" name="username" id="searchName" value="${searchName}" placeholder="根据用户名模糊查询" class="form-control">
                        <span class="input-group-btn">
                <button class="btn btn-info" type="button" onclick="search()">ajax查询</button>
                </span>
                    </div><!-- /input-group -->
                </div><!-- /.col-lg-6 -->
            </div><!-- /.row -->
        </form>
    </div>
</div>
<!--用户列表-->
<div class="container-fluid">
    <div class="table-responsive">
        <table class="table">
            <caption>用户列表</caption>
            <thead>
            <tr>
                <th><input type="checkbox" name="cks"></th>
                <th>序号</th>
                <th>用户名</th>
                <th>密码</th>
                <th>手机号</th>
                <th>出生日期</th>
                <th>头像</th>
                <th>权限</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${pageInfo.list}" varStatus="vs" var="u">
                <tr>
                    <td><input type="checkbox" value="${u.id}" name=""></td>
                    <td>${vs.count}</td>
                    <td>${u.username}</td>
                    <td>${u.password}</td>
                    <td>${u.phone}</td>
                    <td><fmt:formatDate value="${u.birthday}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
                    <td>${u.headerUrl}</td>
                    <td>${u.power==0?"超级管理员":"普通人员"}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<div class="container-fluid" style="text-align: center">
    <ul class="pagination">

        <%--//上一页按钮--%>
        <c:if test="${pageInfo.pageNum>1}">
            <li><a href="javascript:nextPage('${searchName}',${pageInfo.pageNum-1})">&laquo;</a></li>
        </c:if>
        <c:if test="${pageInfo.pageNum<=1}">
            <li class="disabled"><a href="#">&laquo;</a></li>
        </c:if>

        <%----%>
        <c:if test="${pageIfo.pageNum+2<=pageInfo.pages}">
            <c:set var="beginPage" value="${pageInfo.pageNum}"></c:set>
        </c:if>
        <c:if test="${pageInfo.pageNum+2>pageInfo.pages}">
            <c:set var="beginPage" value="${pageInfo.pages-2}"></c:set>
        </c:if>

        <c:if test="${pageInfo.pageNum+2<=pageInfo.pages}">
            <c:set var="endPage" value="${pageInfo.pageNum+2}"></c:set>
        </c:if>
        <c:if test="${pageInfo.pageNum+2>pageInfo.pages}">
            <c:set var="endPage" value="${pageInfo.pages}"></c:set>
        </c:if>

        <c:forEach begin="${beginPage<=1?1:beginPage}" end="${endPage}" var="v">

            <li <c:if test="${pageInfo.pageNum==v}">class="active"</c:if>><a href="javascript:nextPage('${searchName}',${v})">${v}</a></li>
        </c:forEach>

        <%--//下一页按钮--%>
        <c:if test="${pageInfo.pageNum<pageInfo.pages}">
            <li><a href="javascript:nextPage('${searchName}',${pageInfo.pageNum+1})">&raquo;</a></li>
        </c:if>
        <c:if test="${pageInfo.pageNum>=pageInfo.pages}">
            <li class="disabled"><a href="#">&raquo;</a></li>
        </c:if>


        <li><a>当前页${pageInfo.pageNum}/${pageInfo.pages}总页</a></li>

            <%--设置页面大小--%>
        <li class="form-group">
            <a>
                <select class="form-control" id="pageSize"  onchange="changePageSize(this)">
                    <option value="3" <c:if test="${pageSize==3}">selected</c:if>> 3</option>
                    <option value="5" <c:if test="${pageSize==5}">selected</c:if>>5</option>
                    <option value="8" <c:if test="${pageSize==8}">selected</c:if>>8</option>
                    <option value="10" <c:if test="${pageSize==10}">selected</c:if>>10</option>
                </select>
            </a>
        </li>
    </ul>
</div>
