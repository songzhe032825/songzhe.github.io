<%--
  Created by IntelliJ IDEA.
  User: songzhe0328
  Date: 2022/4/26
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>cookie</title>
  </head>
  <body>
  <a href="<%=request.getContextPath()%>/cookie/generate"><br>
    服务器端生成Cookie 然后将生成的Cookie响应给浏览器
    浏览器接受cookie 将cookie保存到客户端上
  </a>
  <a href="<%=request.getContextPath()%>/sendCookie">
    浏览器发送给Cookie给服务器
  </a>
  </body>
</html>
