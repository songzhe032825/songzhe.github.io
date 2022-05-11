<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用json格式的数据</title>
    <script>
       function doSearch(){
           //1.
           var xhr = new XMLHttpRequest();
           //2.
           xhr.onreadystatechange = function (){
               if(xhr.readyState == 4 && xhr.status == 200){
                   //用异步对象获取后端传过来的数据
                   var data = xhr.responseText;
                   //想把json字符串转换成json对象 可以再js中用一个函数eval() 后面会被JQuery替代
                   //字符串和对象是两个概念 字符串：表示文本格式 对象表示属性名和方法
                   //在JS中可以把json格式字符串转换成json对象 json中的key就是json
                   //对象的属性名
                   var jsonObj = xhr.eval("(" +data + ")");
                   //更新dom对象 刷新页面
                   //jsonObj.name:表示json对象的属性名
                   document.getElementById("proname").value = jsonObj.name;
                   document.getElementById("projiancheng").value = jsonObj.jiancheng;
                   document.getElementById("proshenghui").value = jsonObj.shenghui;
               }
               //3.
               var proid = document.getElementById("proid").value;
               xhr.open("get","json?proid=" + proid,true);
               //4.
               xhr.send();
           }
       }
    </script>
</head>
<body>
<p>ajax请求使用json格式数据返回给ajax请求</p>
<table>
    <tr>
        <td>省份编号：</td>
        <td>
            <input type="text" id="proid">
            <input type="submit" value="搜索" onclick="doSearch()">
        </td>
    </tr>
    <tr>
        <td>省份名称：</td>
        <td>
            <input type="text" id="proname">
        </td>
    </tr>
    <tr>
        <td>省份简称：</td>
        <td>
            <input type="text" id="projiancheng">
        </td>
    </tr>
    <tr>
        <td>省份省会：</td>
        <td>
            <input type="text" id="proshenghui">
        </td>
    </tr>
</table>
</body>
</html>
