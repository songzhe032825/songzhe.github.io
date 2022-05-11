package com.bjpowernode.oa.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author 宋哲
 * @version 1.0
 * 全局刷新页面
 */
public class BmiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受请求参数
        String strName = request.getParameter("name");
        String weight = request.getParameter("w");
        String height = request.getParameter("h");

        //计算bmi
        float w = Float.valueOf(weight);
        float h = Float.valueOf(height);
        float bmi = w / (h*h);

        //判断bmi范围
        String msg  ="";
        if(bmi <= 18.5){
            msg="太瘦";
        } else if (bmi>=19 && bmi <=23 ){
            msg="正常";
        }  else if (bmi >=24 && bmi <=32){
            msg ="肥胖";
        } else if (bmi >=33){
            msg = "超重";
        }
        System.out.println("msg=" + msg);
        msg = "您好：" +strName+"先生/女士，您的bmi的值是：" + bmi + "," + msg;
        //存储数据
        request.setAttribute("msg",msg);
        //转发
        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }
}
