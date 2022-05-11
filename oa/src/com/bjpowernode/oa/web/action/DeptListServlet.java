package com.bjpowernode.oa.web.action;

import com.bjpowernode.oa.utils.Dbutils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 宋哲
 * @version 1.0
 *
 */
@SuppressWarnings({"all"})
public class DeptListServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//获取应用的根路径 为查询详情页面做铺垫
		String contextPath = request.getContextPath();
		response.setContentType("text/html");
        	PrintWriter out = response.getWriter();
			out.print("<!DOCTYPE html>");
			out.print(" <html>");
			out.print(" <head>");
			out.print("<meta charset='utf-8'>");
			out.print("<title>部门列表页面</title>");


			out.print("<script type='text/javascript'>");
				out.print("function del(dno){");
					out.print("if(window.confirm('亲 删了不可能恢复哦')){");
					//老子就是因为"/+contextPath+"这个害得我找了一晚上
					out.print("document.location.href = '"+contextPath+"/dept/delete?deptno='+dno");
								out.print("}");
									out.print("}");
			out.print("</script>");



			out.print("</head>");
			out.print("<body>");
			out.print("<h1>部门列表</h1>");
			out.print("<hr >");
			out.print("<table border='1px' align='center' width='50%'>");
			out.print("	<tr>");
			out.print("	<td>序号</td>");
			out.print("<td>部门编号</td>");
			out.print("<td>部门名称</td>");
			out.print("<td>操作</td>");
			out.print("	</tr>");
	 //运用jdbc连接数据库 查询所有部门动态展示出来
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs= null;
			//通过工具类开启连接
			try {
				conn = Dbutils.getConnection();
				//准备一条sql语句
				String sql ="select deptno,dname,loc from dept";
				//预编译处理sql语句
				ps = conn.prepareStatement(sql);
				//处理结果集
				rs = ps.executeQuery();
				int i = 0;
				while(rs.next()){
					String deptno = rs.getString("deptno");
					String dname = rs.getString("dname");
					String loc = rs.getString("loc");
					out.print("	<tr>");
					out.print("		<td>"+(++i)+"</td>");
					out.print("		<td>"+deptno+"</td>");
					out.print("		<td>"+dname+"</td>");
					out.print("		<td>");
					out.print("			<a href='"+contextPath+"/dept/edit?deptno="+deptno+"'>修改</a>");
					out.print("			<a href='javascript:void(0)' onclick='del("+deptno+")'>删除</a>");
					//从超链接入手写查询界面<a href='/项目名/detail.html'>详情</a>"
					out.print("			<a href='"+contextPath+"/dept/detail?deptno="+deptno+"'>详情</a>");
					out.print("		</td>");
					out.print("	</tr>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				//工具类关闭资源链接
				Dbutils.close(conn,ps,rs);
			}
			out.print("</table>");
			out.print("	<hr>");
			out.print("	<a href='"+contextPath+"/add.html'>新增部门</a>");
			out.print("</body>");
			out.print("</html>");
    }
}
