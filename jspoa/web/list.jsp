<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>部门列表</title>
	</head>
	<body>

	<h3>欢迎${username}</h3>
	<a href=${pageContext.request.contextPath}/user/exit">

	</a>
	<script type="text/javascript">
		function del(dno){
			var ok = window.confirm("亲 不可恢复哦");
			if (ok){
				document.location.href="${pageContext.request.contextPath}/dept/delete?deptno=" +dno;
			}
		}
	</script>


		<h1>部门列表</h1>
		<hr >
		<table border="1px" align="center" width="50%">
			<tr>
				<td>序号</td>
				<td>部门编号</td>
				<td>部门名称</td>
				<td>操作</td>
			</tr>

			<c:forEach items="${deptList}" var="dept" varStatus="deptStatus">

			<tr>
				<td>${deptStatus.count}</td>
				<td>${dept.deptno}</td>
				<td>${dept.dname}</td>
				<td>
					<a href="javascript:void(0)" onclick="del(${dept.deptno})">删除</a>
					<a href="${pageContext.request.contextPath}/edit.jsp">修改</a>
					<a href="${pageContext.request.contextPath}/dept/detail?deptno=${dept.deptno}">详情</a>
				</td>
			</tr>

			</c:forEach>

		</table>
	<!-- 跳转新增页面 -->	
		<hr>
		<a href="${pageContext.request.contextPath}/add.jsp">新增部门</a>
	</body>
</html>
