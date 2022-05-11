<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>异步请求</title>
    <script type="text/javascript">
        //发起ajax请求 传递参数给服务器 返回数据
        function search(){
            //1.创建异步对象
            var xhr = new XMLHttpRequest();
            //2.绑定事件 处理后端返回数据 更新页面
            xhr.onreadystatechange=function (){
                if(xhr.readyState == 4 && xhr.status ==200){
                    //alert(xhr.responseText);
                    //更新页面 也就是更新document对象获取value值 页面的省份名称
                     document.getElementById("proname").value = xhr.responseText;
                }
            }
            //3.初始化异步对象
            //我在文本框输入“1” 此时在这里会发生什么？ 获取proid文本框的值
            var proid = document.getElementById("proid");
            //然后proid 会传给proviceAjax
            xhr.open("get","proviceAjax?proid=" + proid,"true");
            //4.发送请求
            xhr.send();
        }
    </script>
</head>
<body>
    <p>ajax根据省份id获取名称</p>
    <table>
        <tr>
            <td>省份编号：</td>
            <td>
                <input type="text" id="proid">
                <input type="submit" value="搜索" onclick="search()">
            </td>
        </tr>
        <tr>
            <td>省份名称：</td>
            <td>
                <input type="text" id="proname">
            </td>
        </tr>
    </table>
</body>
</html>
