import java.sql.*;

public class ConnectDataBaseTest {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/testdata?useSSL=false";
    static final String USER = "root";
    static final String PASS = "123456";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //注册JDBC驱动
            Class.forName(JDBC_DRIVER);

            //打开连接
            System.out.println("正在连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //执行查询
            System.out.println("实力化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT count(*) FROM teachers";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(rs);

            //完成后关闭
            rs.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            //处理Class。forName错误
            e.printStackTrace();
        }catch (SQLException se){
            //处理JDBC错误
            se.printStackTrace();
        }finally {
        }
        System.out.println("再见");

    }
}
