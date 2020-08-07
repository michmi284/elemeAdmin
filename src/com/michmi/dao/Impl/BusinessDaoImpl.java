package com.michmi.dao.Impl;

import com.michmi.dao.BusinessDao;
import com.michmi.domain.Business;
import com.michmi.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao
{

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public List<Business> listBusiness(String businessName, String businessAddress)
    {
        ArrayList<>list= new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from business where 1=1");
        if (businessName!=null && businessName.equals(""))
        {
            //传入了商家名
            sql.append("and businessName like '%").append(businessName).append("%'");
            System.out.println(sql);
        }

        try{
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while(rs.next()){
                Business business = new Business;
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }finally
        {
            JDBCUtils.close(rs,pstmt,conn);
        }

        return null;
    }
}
