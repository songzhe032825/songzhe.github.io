<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List,com.bjpowernode.javabean.Dept" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>部门列表</title>
	</head>
	<body>
		<h1>部门列表</h1>
		<hr >
		<table border="1px" align="center" width="50%">
			<%
				List<Dept> deptList =(List<Dept>)request.getAttribute("deptList");
				int i= 0;
				for (Dept dept : deptList) {
			%>
			<tr>
				<td>序号</td>
				<td>部门编号</td>
				<td>部门名称</td>
				<td>操作</td>
			</tr>
			<tr>
				<td><%=++i%>></td>
				<td><%=dept.getDeptno()%>></td>
				<td><%=dept.getDname()%>></td>
				<td>
					<a href="<%=request.getContextPath()%>/edit.jsp">修改</a>
					<a href="javascript:void(0)" onclick="window.confirm('亲，确认删除该数据吗？')">删除</a>
					<a href="<%=request.getContextPath()%>/detail.jsp">详情</a>
				</td>
			</tr>
			<%
			}
			%>
		</table>
	<!-- 跳转新增页面 -->	
		<hr>
		<a href="<%=request.getContextPath()%>/add.jsp">新增部门</a>
	</body>
</html>
