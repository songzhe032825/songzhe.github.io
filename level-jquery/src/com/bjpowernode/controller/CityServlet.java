package com.bjpowernode.controller;

import com.bjpowernode.dao.QueryDao;
import com.bjpowernode.entity.City;
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
public class CityServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = "{}";
        //获取到省份的id查询到旗下的所有城市
        String strProid = request.getParameter("proid");
        //调用dao层之前判断省份id是否存在
        if(strProid != null && "".equals(strProid.trim())){
            //调用dao层对象
            QueryDao queryDao = new QueryDao();
            List<City> cities = queryDao.queryCityList(Integer.valueOf(strProid));
            //把list 转成 json
            ObjectMapper objectMapper = new ObjectMapper();
             json = objectMapper.writeValueAsString(cities);
        }
        //返回给ajax
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }
}
