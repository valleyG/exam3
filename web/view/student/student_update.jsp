<%--
  Created by IntelliJ IDEA.
  User: zhm
  Date: 2018/5/6
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    //获取绝对路径路径
    String path = request.getContextPath();

    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>添加学生信息</title>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="css/bootstrap.css">
    <script type="application/javascript" src="js/jquery-1.9.0.min.js"></script>
    <script type="application/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
    <div style="margin-top: 80px;">
        <form action="student/updateStudent" method="post" class="form-horizontal">
            <input type="hidden" name="sId" value="${currentStudent.sId}">
            <div class="form-group">
                <div class="col-xs-5 ">
                    <label for="sName" class="col-xs-4 control-label">学生姓名：</label>
                    <div class="col-xs-8 "><input type="text" class="form-control" name="sName" id="sName" placeholder="请输入学生名字" value="${currentStudent.sName}"> </div>
                </div>
                <div class="col-xs-5 col-xs-offset-1">
                    <label for="cId" class="col-xs-4 control-label">班级名称：</label>
                    <div class="col-xs-8 ">
                        <select name="cId" id="cId" class="form-control">
                            <c:forEach items="${grades}" var="grade">
                                <option value="${grade.cId}" ${currentStudent.cId==grade.cId?'selected':''}>${grade.cName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="col-xs-5 ">
                    <label for="sSex" class="col-xs-4 control-label">学生性别：</label>
                    <div class="col-xs-8">
                        <select name="sSex" id="sSex" class="form-control">
                            <option value="男" ${currentStudent.sSex=='男'?'selected':''}>男</option>
                            <option value="女" ${currentStudent.sSex=='女'?'selected':''}>女</option>
                        </select>
                    </div>
                </div>
                <div class="col-xs-5 col-xs-offset-1">
                    <label for="sAge" class="col-xs-4 control-label">学生年龄：</label>
                    <div class="col-xs-8">
                        <input type="text" id="sAge" name="sAge" class="form-control" placeholder="请输入学生年龄" value="${currentStudent.sAge}">
                    </div>
                </div>
            </div>
            <div class="form-group col-xs-8 col-xs-offset-4">
                <button type="submit" class="btn btn-success col-xs-offset-10" style="width: 100px;"><span class="glyphicon glyphicon-plus"></span> 修改信息</button>
            </div>

        </form>
    </div>

</body>
</html>
