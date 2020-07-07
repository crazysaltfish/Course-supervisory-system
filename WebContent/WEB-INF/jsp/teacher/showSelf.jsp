<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title></title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 引入bootstrap -->
	<link rel="stylesheet" type="text/css" href="/Edu/css/bootstrap.min.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="/Edu/js/jquery-3.2.1.min.js"></script>
	<script src="/Edu/js/bootstrap.min.js"></script>
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
					    	<h1 style="text-align: center;">教师个人信息</h1>
						</div>
				    </div>
				    <div class="panel-body">
						<form class="form-horizontal" role="form" action="editTeacher" id="editfrom" method="post">
							  <div class="form-group">
							    <label for="inputEmail3" class="col-sm-2 control-label">工号</label>
							    <div class="col-sm-10">
							      <input readonly="readonly" type="number" class="form-control" id="inputEmail3" name="userid" placeholder="请输入工号" value="${teacher.userid}">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputPassword3" class="col-sm-2 control-label">姓名</label>
							    <div class="col-sm-10">
							      <input readonly="readonly" type="text" class="form-control" id="inputPassword3" name="username" placeholder="请输入姓名" value="${teacher.username}">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputPassword3" class="col-sm-2 control-label">性别</label>
							    <div class="col-sm-10">
							      <input readonly="readonly" type="text" class="form-control" id="inputPassword3" name="sex" placeholder="请输入姓名" value="${teacher.sex}">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputPassword3" class="col-sm-2 control-label">出生年份</label>
							    <div class="col-sm-10">
								    <input readonly="readonly" type="date" value="<fmt:formatDate value="${teacher.birthyear}" dateStyle="medium" pattern="yyyy-MM-dd" />" name="birthyear"/>
							    </div>
							  </div>
							  <div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label" name="degree">学历：</label>
								<div class="col-sm-10">
							      <input readonly="readonly" type="text" class="form-control" id="inputPassword3" name="degree" placeholder="请输入姓名" value="${teacher.degree}">
							    </div>
							  </div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label" name="title" >职称：</label>
								<div class="col-sm-10">
							      <input readonly="readonly" type="text" class="form-control" id="inputPassword3" name="title" placeholder="请输入姓名" value="${teacher.title}">
							    </div>
							</div>
							  <div class="form-group">
							    <label for="inputPassword3" class="col-sm-2 control-label" name="grade">入职时间</label>
							    <div class="col-sm-10">
								    <input readonly="readonly" type="date" value="<fmt:formatDate value="${teacher.grade}" dateStyle="medium" pattern="yyyy-MM-dd" />" name="grade"/>
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputPassword3" class="col-sm-2 control-label" name="grade">所属院系</label>
							     <div class="col-sm-10">
							      <input readonly="readonly" type="text" class="form-control" id="inputPassword3" name="collegeid"  value="${teacher.collegeid}">
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
		$("#nav li:nth-child(3)").addClass("active");


	</script>
</html>