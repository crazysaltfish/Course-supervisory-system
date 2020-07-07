<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title>个人信息显示</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 引入bootstrap -->
	<link rel="stylesheet" type="text/css" href="/Edu/css/bootstrap.min.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="/Edu/js/jquery-3.2.1.min.js"></script>
	<script src="/Edu/js/bootstrap.min.js"></script>

	<%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>

</head>
<body>
	<!-- 顶栏 -->
	<jsp:include page="top.jsp"></jsp:include>
	<!-- 中间主体 -->
		<div class="container" id="content">
		<div class="row">
			<jsp:include page="menu.jsp"></jsp:include>
			<div class="col-md-10">
				<div class="panel panel-default">
				    <div class="panel-heading">
						<div class="row">
					    	<h1 style="text-align: center;">学生个人信息</h1>
						</div>
				    </div>
				    <div class="panel-body">
						<form class="form-horizontal" role="form" action="editStudent" id="editfrom" method="post">
							  <div class="form-group ">
							    <label for="inputEmail3" class="col-sm-2 control-label" >学号</label>
							    <div class="col-sm-10">
							      <input readonly="readonly" type="number" class="form-control" id="inputEmail3" name="userid" placeholder="请输入学号"
								  <c:if test='${student!=null}'>
										 value="${student.userid}"
								  </c:if>>
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputPassword3" class="col-sm-2 control-label">姓名</label>
							    <div class="col-sm-10">
							      <input readonly="readonly" type="text" class="form-control" id="inputPassword3" name="username" placeholder="请输入姓名" value="${student.username}">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputPassword3" class="col-sm-2 control-label">性别</label>
							    <div class="col-sm-10">
							      <input readonly="readonly" type="text" class="form-control" id="inputPassword3" name="username"  value="${student.sex}">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputPassword3" class="col-sm-2 control-label">出生年份</label>
							    <div class="col-sm-10">
								    <input readonly="readonly" type="date" value="<fmt:formatDate value="${student.birthyear}" dateStyle="medium" pattern="yyyy-MM-dd" />" name="birthyear"/>
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputPassword3" class="col-sm-2 control-label" name="grade">入学时间</label>
							    <div class="col-sm-10">
								    <input readonly="readonly" type="date" value="<fmt:formatDate value="${student.grade}" dateStyle="medium" pattern="yyyy-MM-dd" />" name="grade"/>
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputPassword3" class="col-sm-2 control-label" name="grade">所属院系</label>
							    <div class="col-sm-10">
							      <input readonly="readonly" type="text" class="form-control" id="inputPassword3" name="username"  value="${student.collegeid}">
							    </div>
							  </div>
						</form>
				    </div>
				    
				</div>

			</div>
		</div>
	</div>
	<div class="container" id="footer">
	<div class="row">
		<div class="col-md-12"></div>
	</div>
	</div>
</body>
	<script type="text/javascript">
		<%--设置菜单中--%>
		$("#nav li:nth-child(4)").addClass("active")
        
	</script>
</html>