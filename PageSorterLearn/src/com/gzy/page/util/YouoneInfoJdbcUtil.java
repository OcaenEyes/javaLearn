package com.gzy.page.util;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class YouoneInfoJdbcUtil {
    private static String USERNAME;
    private static String PASSWORD;
    private static String JDBC_DRIVER;
    private static String URL;

    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet resultSet;

    static {
        loadConfig();
    }

    public static void loadConfig() {
        InputStream inStream = YouoneInfoJdbcUtil.class.getResourceAsStream("/jdbc.proterties");
        Properties prop = new Properties();
        USERNAME = prop.getProperty("jdbc.username");
        PASSWORD = prop.getProperty("jdbc.password");
        JDBC_DRIVER = prop.getProperty("jdbc.driver");
        URL = prop.getProperty("jdbc.url");
        try {
            prop.load(inStream);
        } catch (Exception e) {
            throw new RuntimeException("读取配置文件异常！", e);
        }
    }

    public YouoneInfoJdbcUtil() {
    }

    /**
     * 连接数据库
     *
     * @return数据库连接
     */
    public Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("数据库连接失败", e);
        }
        return connection;
    }

    /**
     * 执行更新操作
     *
     * @param sql
     * @param params 参数
     * @return 执行结果
     * @throws SQLException
     */
    public boolean updateByPreparedStatement(String sql, List<?> params) throws SQLException {
        boolean flag = false;
        int result = -1;
        pstmt = connection.prepareStatement(sql);
        int index = 1;

        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                pstmt.setObject(index++, params.get(i));
            }
        }
        result = pstmt.executeUpdate();
        flag = result > 0 ? true : false;
        return flag;
    }

    /**
     * 执行查询操作
     *
     * @param sql
     * @param params
     * @return 查询结果
     * @throws SQLException
     */
    public List<Map<String, Object>> selectResult(String sql, List<?> params) throws SQLException {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        int index = 1;
        pstmt = connection.prepareStatement(sql);
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                pstmt.setObject(index++, params.get(i));
            }
        }

        resultSet = pstmt.getResultSet();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int cols_len = metaData.getColumnCount();
        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<String, Object>();
            for (int i = 0; i < cols_len; i++) {
                String cols_name = metaData.getColumnName(i + 1);
                Object cols_value = resultSet.getObject(cols_name);
                if (cols_value == null) {
                    cols_value = "";
                }
                map.put(cols_name, cols_value);
            }
            list.add(map);

        }
        return list;
    }

    /**
     * 释放资源
     */
    public void releaseConn(){
        if (resultSet != null){
            try {
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        if (pstmt != null){
            try {
                pstmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        if (connection != null){
            try {
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
