package com.bjpowernode.cotroller;

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
public class BmiAjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ajax作用出来了吗");
        //接受请求参数
        String strName = request.getParameter("name");
        String weight = request.getParameter("w");
        String height = request.getParameter("h");

        //计算bmi
        float w = Float.valueOf(weight);
        float h = Float.valueOf(height);
        float bmi = w / (h * h);

        //判断bmi范围
        String msg = "";
        if (bmi <= 18.5) {
            msg = "太瘦";
        } else if (bmi >= 19 && bmi <= 23) {
            msg = "正常";
        } else if (bmi >= 24 && bmi <= 32) {
            msg = "肥胖";
        } else if (bmi >= 33) {
            msg = "超重";
        }
        System.out.println("msg=" + msg + "strName=" + strName);
        //用HttpServletResponse输出数据
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(msg);
        //刷新
        out.flush();
        //关闭
        out.close();
    }
}
