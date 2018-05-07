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
<html>
<head>
    <title>添加学生信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="/css/bootstrap.css">
    <script type="application/javascript" src="/js/jquery-1.9.0.min.js"></script>
    <script type="application/javascript" src="/js/bootstrap.min.js"></script>
</head>
<body>
            <div style="margin-top: 80px;">
                <form action="/grade/updateGrade" method="post" class="form-horizontal">
                    <input type="hidden" name="cId" value="${grade.cId}">
                    <div class="form-group">
                        <div class="col-xs-5">
                            <label for="cName" class="col-xs-4 col-xs-offset-1 control-label">班级名称：</label>
                            <div class="col-xs-5">
                                <input type="text" name="cName" id="cName" class="form-control" value="${grade.cName}">
                            </div>
                        </div>

                        <div class="col-xs-5 col-xs-offset-2">
                            <button type="submit" class="btn btn-success ">修改信息</button>
                        </div>
                    </div>
        </form>
    </div>

</body>
</html>
