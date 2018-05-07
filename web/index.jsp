<%--
  Created by IntelliJ IDEA.
  User: zhm
  Date: 2018/5/6
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //获取绝对路径路径
  String path = request.getContextPath();

  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>
<html>
  <head>
    <title>首页</title>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="css/bootstrap.css">
    <script type="application/javascript" src="js/jquery-1.9.0.min.js"></script>
    <script type="application/javascript" src="js/bootstrap.min.js"></script>
  </head>
  <body>
  <div class="col-xs-8 col-xs-offset-2">
    <nav class="navbar-default navbar">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand">导航</a>
        </div>
        <ul class="nav navbar-nav">
          <li><a href="student/queryStudent" target="mainFrame">学生信息</a></li>
          <li><a href="grade/queryGrades" target="mainFrame">班级信息</a></li>
          <li></li>
        </ul>
      </div>
    </nav>
    <div>
      <iframe src="" id="mainFrame" name="mainFrame" style="width: 880px;height: 500px;"></iframe>
    </div>
  </div>
  </body>
</html>
