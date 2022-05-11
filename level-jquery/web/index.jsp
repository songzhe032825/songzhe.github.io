<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>省市级联查询</title>
      <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
      <script type="text/javascript">
        //封装思想
        function loadDataAjax(){
          //实现ajax()请求 用json格式
          $.ajax({
            url:"provinceservlet",
            type:"get",
            //Servlet返回的“application/json”
            dataType:"json",
            success:function (resp) {
              //$.each:循环json数组 n：表示数组成员
              $.each(resp,function (i,n){
                //获取select dom对象
                //append 增加div  option 数据来自数组循环内容
                $("#province").append("<option value='"+n.id+"'>"+n.name + "</option>");
              })
            }
          })
        }
        //加载页面
          $(function(){
            loadDataAjax();
            //页面单击按钮
            $("#btnLoad").click(function (){
              loadDataAjax();
            })
            //如何知道我选择的是什么 ？ 比如选陕西就是陕西
            //需要用到我们的change事件 给省份select绑定一个change事件
            //当select内容发生改变时 触发事件
            $("#province").change(function (){
              //获取选中的列表的值
              var obj = $("#province>option:selected");
              //alert("select 的change事件" + obj.val() + "=====" + obj.text())
              //省份编号 1，2，3
              var proviceId = obj.val();
              //再根据省份编号查询省份下的城市 加到请”选择下“ 现在我要写city后端代码
              //json{参数名:"参数值"} {proid:proviceId}
              $.post("cityservlet",{proid:proviceId},
              function (resp){
                //清空列表
                $("#city").empty();
                //alert(resp);
                //获取resp数组的数据到“城市的选择下” 思路和省那个一样
                $.each(resp,function (i,n){
                    $("#city").append("<option value='"+n.id+"'>"+n.name + "</option>");
                })
              },"json");
            })
          })
      </script>
  </head>
  <body>
          <p>省市级联查询 使用ajax</p>
          <div>
            <table border="1" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  省份名称：
                </td>
                <td>
                  <select id="province">
                    <option value="0">
                      请选择.....
                    </option>
                  </select>
                  <input type="button" value="load数据" id="btnLoad"/>
                </td>
              </tr>
                  <tr>
                    <td>
                      城市：
                    </td>
                    <td>
                      <select id="city">
                          <option value="0">
                            请选择...
                          </option>
                      </select>
                    </td>
                  </tr>
            </table>
          </div>
  </body>
</html>
