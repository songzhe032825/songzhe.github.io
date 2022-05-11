package com.bjpowernode.dao;

import com.bjpowernode.entity.City;
import com.bjpowernode.entity.Province;

import com.bjpowernode.utils.Dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 宋哲
 * @version 1.0
 * dao连接数据库
 */
@SuppressWarnings({"all"})
public class QueryDao {
    //查询所有省份的信息
    public List<Province> queryProvinceList(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        Province province = null;
        List<Province> provinces = new ArrayList<>();
        try {
            conn = Dbutils.getConnection();
            String sql = "select id,name,jiancheng,shenghui from province order by id";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                 province= new Province();
                 province.setId(rs.getInt("id"));
                 province.setName(rs.getString("name"));
                 province.setJiancheng(rs.getString("jiancheng"));
                 province.setShenghui(rs.getString("shenghui"));
                 //添加数据
                provinces.add(province);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
           Dbutils.close(conn,ps,rs);
        }
        return provinces;
    }
    //查询所有省份下所有城市的信息
    public List<City> queryCityList(Integer provinceId){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        City city = null;
        List<City> cities = new ArrayList<>();
        try {
            conn = Dbutils.getConnection();
            String sql = "select id,name from city where provinceId = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,provinceId);
            rs = ps.executeQuery();
            while (rs.next()) {
                city = new City();
                city.setId(rs.getInt("id"));
                city.setName(rs.getString("name"));
                //添加数据
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Dbutils.close(conn,ps,rs);
        }
        return cities;
    }
}
