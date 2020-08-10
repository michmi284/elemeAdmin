package com.michmi.dao.Impl;

import com.michmi.dao.FoodDao;
import com.michmi.domain.Food;
import com.michmi.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao
{
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public List<Food> findAll(Integer businessId)
    {
        ArrayList<Food> list = new ArrayList<>();

        String sql = "select * from food where businessId= ?";
        try
        {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, businessId);
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                Food food = new Food();
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodPrice(rs.getDouble("foodPrice"));
                food.setBusinessId(rs.getInt("businessId"));
                list.add(food);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            JDBCUtils.close(rs, pstmt, conn);
        }

        return list;
    }

    @Override
    public Food getFoodById(Integer foodId)
    {
        Food food = null;
        String sql = "select * from food where foodId = ? ";
        try
        {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, foodId);
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                food = new Food();
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodPrice(rs.getDouble("foodPrice"));
                food.setBusinessId(rs.getInt("businessId"));

            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            JDBCUtils.close(rs, pstmt, conn);
        }

        return food;
    }

    @Override
    public int saveFood(Food food)
    {
        int foodId = 0;
        // 附带一个初始密码
        String sql = "insert into food(foodName, foodExplain,foodPrice)values(?,?,?)";
        try
        {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            // 可以在prepareStatement中设置返回自增长列的值
            pstmt.setString(1, "foodName");
            pstmt.setString(2, "foodExplain");
            pstmt.setString(3, "foodPrice");
            pstmt.executeUpdate();
            // 获取自增长的列
            rs = pstmt.getGeneratedKeys();
            if (rs.next())
            {
                foodId = rs.getInt(1);
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return foodId;
    }

    @Override
    public int updateFood(Food food)
    {
        int result = 0;
        String sql = "update food set foodName = ?,foodExplain=?,foodPrice=? where foodId = ? ";
        try
        {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, food.getFoodName());
            pstmt.setString(2, food.getFoodExplain());
            pstmt.setDouble(3, food.getFoodPrice());
            pstmt.setInt(4, food.getFoodId());
            result = pstmt.executeUpdate();

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            JDBCUtils.close(null, pstmt, conn);
        }
        return result;
    }

    @Override
    public int removeFood(Integer foodId)
    {
        int result = 0;
        String sql = "delete from food where foodId = ?";

        try
        {
            conn = JDBCUtils.getConnection();
            // 手动开启事物
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, foodId);
            result = pstmt.executeUpdate();
            conn.commit();

        } catch (SQLException e)
        {
            // 进入了异常的代码区要给result置为 0
            result = 0;
            try
            {
                conn.rollback();
            } catch (SQLException e1)
            {
                e1.printStackTrace();
            }
            e.printStackTrace();


        } finally
        {
            JDBCUtils.close(rs, pstmt, conn);
        }

        return result;
    }
}