<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>省市级联查询</title>
      <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
      <script type="text/javascript">
          $(function(){
            $("#btnLoad").click(function (){
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
