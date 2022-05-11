<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>局部刷新</title>
        <script type="text/javascript">
            <!--核心使用内存中的异步对象来代替浏览器发起请求-->
            <!--异步对象是使用JS来创建和管理的-->
            function doAjax(){
              //1.创建异步对象
              var xhr = new XMLHttpRequest();
              //2.绑定事件
              xhr.onreadystatechange = function (){
                  //处理服务器端的返回数据 更新页面
                  if(xhr.readyState == 4&& xhr.status == 200){
                     //alert(xhr.responseText);//把后端的msg传到responseText这里
                      //数据更新dom对象 更新页面数据
                      var data = xhr.responseText;
                      document.getElementById("mydata").innerText = data;
                  }
              }

              //3.初始请求参数("请求方式","请求地址","是否异步")
              var name =  document.getElementById("name").value;
              var w = document.getElementById("w").value;
              var h = document.getElementById("h").value;
              //bmiprint?name=李四&w=8&h=1.8
              var param = "name=" + name + "&w=" + w +
                    "&h=" + h;
              xhr.open("get","bmiAjax?"+param,"true");
              //4.异步对象代替浏览器发起请求
              xhr.send();
            }
        </script>
  </head>
  <body>
      <p>局部刷新ajax-计算bmi</p>
      <!--没有使用form表单-->
     姓名：<input type="text" id="name"/> <br>
     体重：<input type="text" id="w"/> <br>
     身高：<input type="text" id="h"/> <br>
  <input type="button" value="计算bmi" onclick="doAjax()">
  <div id="mydata">
        等待加载数据来服务器端....
  </div>
  </body>
</html>
