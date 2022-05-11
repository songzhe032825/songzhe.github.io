package com.bjpowernode.cotroller;

import com.bjpowernode.dao.ProvinceDao;
import com.bjpowernode.entity.Province;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 宋哲
 * @version 1.0
 */
public class QueryJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //定义默认值 {}：表示json格式的数据
        String json = "{}";
        //根据获取请求参数id省份对象

        String strProId = request.getParameter("proid");
        //判断proid是否为空
        //当有值时 调用dao层 查询数据库
        if(strProId != null && strProId.trim().length()>0){
            //有值 然后调用dao层 创建dao层对象
            ProvinceDao pd = new ProvinceDao();
            Province province = pd.queryProviceById(Integer.valueOf(strProId));
            //将对象数据格式转成json串形式返回给ajax
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(province);

        }
        System.out.println("json=" + json);
        //最后通过网络传给ajax中的异步对象 响应结果数据
        //指定服务器端传给浏览器端是json格式数据
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        //刷新
        out.flush();
        //关闭
        out.close();
    }
}
