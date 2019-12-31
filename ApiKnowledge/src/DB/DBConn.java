package DB;

import java.sql.*;

public class DBConn {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/testdata?useSSL=false";
    static final String user = "root";
    static final String pass = "123456";
    static Connection conn;
    static ResultSet rs;
    static PreparedStatement ps;

    public static Connection init() {
        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("连接数据库成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("init [SQL驱动服务失败]");
            e.printStackTrace();
        }
        return conn;
    }

    // 增删改查
    public static int addUpdDel(String sql) {
        int i = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            i = ps.executeUpdate();
        } catch (SQLException se) {
            System.out.println("SQL数据库增删改查失败");
            se.printStackTrace();
        }
        return i;
    }


    // 查询语句
    public static ResultSet selectSQL(String sql) {
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            System.out.println("数据查询成功");

        } catch (SQLException se) {
            System.out.println("SQL数据库查询失败");
            se.printStackTrace();
        }
        return rs;
    }


    // 关闭数据库连接
    public static void closeConn() {
        try {
            conn.close();
            System.out.println("数据库关闭成功");
        } catch (SQLException se) {
            System.out.println("SQL数据库关闭异常");
            se.printStackTrace();
        }
    }

}
