package com.bjpowernode.dao;

import com.bjpowernode.entity.Province;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

/**
 * @author 宋哲
 * @version 1.0
 * Dao层只负责连接数据库
 */
@SuppressWarnings({"all"})
public class ProvinceDao {
        //获取id获取名称
        public String queryProviceNameById(Integer proviceId)  {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "";
            String url = "jdbc:mysql://localhost:3306/db02";
            String username = "root";
            String password = "hsp";
            //加载驱动
            String name = "";
            try {

                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, username, password);
                sql = "select name from province where id= ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, proviceId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    name = rs.getString("name");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (ps != null) {
                        ps.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            //根据id编号查询到只有省份名称
            return name;
        }

    //获取id获取一个完整的province对象
    public Province queryProviceById(Integer proviceId)  {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Province province = null;
        String sql = "";
        String url = "jdbc:mysql://localhost:3306/db02";
        String username = "root";
        String password = "hsp";
        //加载驱动
        String name = "";
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            sql = "select id,name,jiancheng,shenghui from province where id= ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, proviceId);
            rs = ps.executeQuery();
            while (rs.next()) {
                province = new Province();
                province.setId(rs.getInt("id"));
                province.setName(rs.getString("name"));
                province.setJiancheng(rs.getString("jiancheng"));
                province.setShenghui(rs.getString("shenghui"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //根据id编号查询到一整个对象 不单单只有名称
        return province;
    }
}
