<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JQuery发起的ajax请求</title>
    <script type="text/javascript" src="/js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function (){
            $("#btn").click(function (){
                //获取dom的value值 getElementById("proid").value
                var proid = $("#proid").val();
                //发起ajax请求
                $.ajax({
                    //"json  ?proid="
                    url:"json",
                    type:"get",
                    //json数据,传值"proid":定义变量proid
                    data:{"proid":proid},
                    dataType:"json",
                    success:function (resp){
                        //更新数据
                        alert(name+"===="+jiancheng);
                       $("#proname").val(resp.name);
                       $("#projiancheng").val(resp.jiancheng);
                       $("#proshenghui").val(resp.shenghui);
                    }
                })
            })
        });
    </script>
</head>
<body>
<p>ajax请求使用json格式数据返回给ajax请求</p>
<table>
    <tr>
        <td>省份编号：</td>
        <td>
            <input type="text" id="proid">
            <input type="submit" value="搜索" id="btn"/>
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
