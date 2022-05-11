<%@page import="com.njpowernode.javaweb.javabean.User" %>
<%@ page import="com.njpowernode.javaweb.javabean.Address" %>
<%@page contentType="text/html; charset=utf-8" %>
<%--在四大作用域中存数据--%>
<%
    //创建User对象
    User user = new User();
    user.setName("han");
    user.setAge(10);
    user.setPassword("123");

    //创建Address对象
    Address address = new Address();
    address.setCity("北京");
    address.setStreet("大兴区");
    address.setZipcode("111111111");

    user.setAddr(address);
    //将数据存储在四大作用域当中
    request.setAttribute("userObj",user);

%>
<%--说明一下 EL表达式是存数据的键 把双引号拿掉
然后必须在四大作用域之下执行 而且作用是取数据和输出到浏览器 只能执行
只跟属性的get方法有关 首字母是小写--%>
<%--我想查询用户的具体信息--%>
${userObj.name}<br>
${userObj.age}<br>
${userObj.password}<br>

<%--我想查询用户所在具体的城市--%>
${userObj.addr.city} <br>
${userObj.addr.street}<br>
${userObj.addr.zipcode}<br>
<%--1.获取应用根路径--%>
<%--在EL表达式中没有request的隐含对象 想要获取这个request需要pageContext来调用--%>
${pageContext.request.contextPath}<br>
<%--2.用来获取用户发送的请求参数--%>
${param.username}<br>
<%--3.用来获取用户参数一维数组中的第一个元素--%>
<%--用http://localhost:8080/aaaa/index.jsp?aihao=smoke&aihao=tangtou&aihao=drink--%>
${param.aihao}<%--smoke--%><br>
<%--4.用来获取用户参数一维数组--%>
${paramValues.aihao}<br>
<%--5.用来获取用户参数一维数组的下标元素[]--%>
${paramValues.aihao[0]}、${paramValues.aihao[1]}、${paramValues.aihao[2]}<br>
每页显示记录条数：${initParam.pageSize}
页码数：${initParam.pageNum}
