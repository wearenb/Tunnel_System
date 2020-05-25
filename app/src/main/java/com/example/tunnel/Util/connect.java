package com.example.tunnel.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class connect {
    private static String driver = "com.mysql.jdbc.Driver";// MySql驱动

    //private static String url = "jdbc:mysql://localhost:3306/map_designer_test_db";

    private static String user = "root";// 用户名

    private static String password = "q2733056755";// 密码


    public static Connection getConnect(){//获取数据库连接

        Connection connection = null;
        try{
            Class.forName(driver);// 动态加载类
            String ip = "192.168.173.1";// 写成本机地址，不能写成localhost，同时手机和电脑连接的网络必须是同一个

            // 尝试建立到给定数据库URL的连接
            connection = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + "tunnel",
                    user, password);

        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }



    public static void closeAll(Connection conn, PreparedStatement ps){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
