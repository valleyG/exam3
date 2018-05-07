<%--
  Created by IntelliJ IDEA.
  User: zhm
  Date: 2018/5/6
  Time: 15:18
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
    <title>学生列表信息</title>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="css/bootstrap.css">
    <script type="application/javascript" src="js/jquery-1.9.0.min.js"></script>
    <script type="application/javascript" src="js/bootstrap.min.js"></script>
</head>
<script>
    // $(function () {
    //     $("#del").click(function () {
    //        var sId = $(this).attr('data');
    //        alert(sId);
    //        // $(this).attr("href","/student/deleteStudent?sId="+sId);
    //        // $(this).click();
    //     });
    //
    // });
    function del(even) {
        var cId = $(even).attr('data');
        var flag = window.confirm("确认删除？");
        if(flag){
            var a = document.createElement('a');
            a.setAttribute("href","grade/deleteGrade?cId="+cId);
            a.click();
        }
    }
</script>
<body>
    <div>
        <div class="" style="margin-top: 10px;">
            <div class="pager" style="color: red;">${tip!=null?tip:''}</div>
            <form action="grade/queryGrades" method="post" class="form-inline" id="form" style="text-align: center">
                <label for="sName">学生姓名:</label><input type="text" id="sName" name="sName" class="form-control" placeholder="请输入学生姓名" value="${condition.sName}">	&nbsp;	&nbsp;
                <label >班级:</label>
                <select name="cId" id="cId" class="form-control">
                    <option value="0">请选择</option>
                    <c:forEach items="${grades}" var="grade">
                        <option value="${grade.cId}" ${condition.cId==grade.cId?'selected':''}>${grade.cName}</option>
                    </c:forEach>
                </select>	&nbsp;	&nbsp;
                <input type="submit" class="form-control btn btn-primary" value="查询">
                <a href="view/grade/grade_add.jsp" class="btn btn-success" target="mainFrame">添加班级信息</a>
            </form>

        </div>
        
        
        <div style="margin-top: 10px;">
            <table class="table table-responsive">
                <thead>
                    <tr>
                        <td>班级编号</td>
                        <td>班级名称</td>
                        <td>操作</td>
                    </tr>
                </thead>
                <tbody>
                      <f:forEach items="${queryGrades}" var="grade">
                          <tr>
                              <td>${grade.cId}</td>
                              <td>${grade.cName}</td>
                              <td><a href="grade/updateGrade?cId=${grade.cId}" target="mainFrame">修改</a>
                                  &nbsp;	&nbsp;<a href="javascript:void(0)" target="mainFrame"
                             data="${grade.cId}" onclick="del(this)">删除</a></td>
                          </tr>
                      </f:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
