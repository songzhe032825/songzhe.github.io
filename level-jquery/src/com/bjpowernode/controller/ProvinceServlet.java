package com.bjpowernode.controller;

import com.bjpowernode.dao.QueryDao;
import com.bjpowernode.entity.Province;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author 宋哲
 * @version 1.0
 */
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = "{}";
        //调用dao层 获取所有省份的信息 是一个list集合
        QueryDao dao = new QueryDao();
        List<Province> provinces = dao.queryProvinceList();
        //把list转为json格式的数据 传输给ajax
        if(provinces != null){
            //证明有数据把 然后调用jackson工具库 实现list-json的转变
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(provinces);
        }
        //输出json 响应到浏览器
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }
}
