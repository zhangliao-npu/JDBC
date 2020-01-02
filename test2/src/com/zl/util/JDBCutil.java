package com.zl.util;
import java.sql.*;
import java.util.*;
public class JDBCutil {
    // 用static代码块是为了率先加载且只加载一次
    public static  Connection getconnection() {
        // 用ResourceBundle将db.properties传入
        ResourceBundle rb = ResourceBundle.getBundle("db");
        final String driverClass = rb.getString("driver");
        final String url = rb.getString("url");
        final String username = rb.getString("username");
        final String password = rb.getString("password");
        Connection conn=null;
        try {
            // 1.注册并连接驱动
            Class.forName(driverClass);
            conn=DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // 2.关闭资源
    public static void closeAll(ResultSet rs, Statement st, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

