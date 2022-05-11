package com.bjpowernode.cotroller;

import com.bjpowernode.dao.ProvinceDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * @author 宋哲
 * @version 1.0
 * Cotroller层负责处理业务
 */
public class QueryProviceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理get请求
        //System.out.println("响应到ajax请求");
        String strproid = request.getParameter("proid");
        System.out.println("strproid =" + strproid);
        String name ="默认是无数据";
        //访问dao层 查询数据库
        if(strproid != null && !"".equals(strproid.trim())){

            //创建dao对象
            ProvinceDao provinceDao = new ProvinceDao();
            //调用dao层方法
            provinceDao.queryProviceNameById(Integer.valueOf(strproid));
        }
        //使用异步对象HttpServletResponse输出的返回数据
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //out.println("中国");
        out.println(name);
        out.flush();
        out.close();
    }
}
