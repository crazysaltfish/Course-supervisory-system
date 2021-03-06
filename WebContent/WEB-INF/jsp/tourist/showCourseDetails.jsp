<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title>课程信息显示</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 引入bootstrap -->
	<link rel="stylesheet" type="text/css" href="/Edu/css/bootstrap.min.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="/Edu/js/jquery-3.2.1.min.js"></script>
	<script src="/Edu/js/bootstrap.min.js"></script>

	<%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
<style type="text/css">
table tr:nth-child(odd){background:#F4F4F4;}
table td:nth-child(even){color:#C00;}
/* table tr:nth-child(5){background:#73B1E0;color:#FFF;} */
</style>
</head>
<body>
	<!-- 顶栏 -->
	<jsp:include page="top.jsp"></jsp:include>
	<!-- 中间主体 -->
	<div class="container" id="content">
		<div class="row">
			<div class="col-md-12">
				
		   <div class="panel panel-default">
		    <div class="panel-heading">
				<div class="row">
			    	<h1 class="col-md-5">课程详情</h1>
					

				</div>
		    </div>
  <table class="table table-bordered">
       <thead>
           <tr>
			<th colspan="2">课程:</th>
			<th colspan="10">${coursename}</th>
           </tr>
       </thead>
       <tbody>
		<tr>
			<td colspan="2">任课老师  </td>
			<td colspan="10">${teachername}      </td>
			
		</tr>
		<tr>
			<td colspan="2">课程介绍 </td>
			<td colspan="10"> ${coursedetails.mark} </td>
			
		</tr>
		<tr>
			<td colspan="2">课程资源 </td>
			<td colspan="10">
			游客暂不提供
			</td>
			
		</tr>
	   </tbody>
    </table>
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
		$("#nav li:nth-child(1)").addClass("active")
        <c:if test="${pagingVO != null}">
        if (${pagingVO.curentPageNo} == ${pagingVO.totalCount}) {
            $(".pagination li:last-child").addClass("disabled")
        };

        if (${pagingVO.curentPageNo} == ${1}) {
            $(".pagination li:nth-child(1)").addClass("disabled")
        };
        </c:if>

        function confirmd() {
            var msg = "您真的确定要删除吗？！";
            if (confirm(msg)==true){
                return true;
            }else{
                return false;
            }
        }

        $("#sub").click(function () {
            $("#form1").submit();
        });
        
        function showCourseDetails(){
        	
        	location.href = "showCourseDetails";
        	
        }	
        	
        
	</script>
</html>