<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bjpowernode.javaweb.bean.Student" %>
<%@page contentType="text/html; charset=UTF-8"%>
<%--引入标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    //创建list集合
    List<Student> stuList = new ArrayList<>();
    //创建Student对象
    Student s1 = new Student("110", "警察");
    Student s2 = new Student("120", "小偷");
    Student s3 = new Student("130", "鬼子");

    stuList.add(s1);
    stuList.add(s2);
    stuList.add(s3);

    request.setAttribute("stuList",stuList);
%>
<%--需求将list集合中的元素stuList遍历 取出下标元素 也就是学生信息输出到浏览器--%>
<%--JSTL集合EL表达式取代JAVA程序--%>
<c:forEach items="${stuList}" var ="s" varStatus="status">
    id:${s.id},name:${s.name}<br>
</c:forEach>