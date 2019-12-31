package DB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class test03 {
    public static void main(String[] args) throws SQLException {
        DBConn.init();
        ResultSet rs = DBConn.selectSQL("SELECT * FROM teachers");
        while (rs.next()){
            String tname = rs.getString("tname");
            String tbirthday = rs.getString("tbirthday");
            String prof = rs.getString("prof");

            System.out.print(tname);
            System.out.print(tbirthday);
            System.out.print(prof);
            System.out.print("\n");

        }
        DBConn.closeConn();
    }
}
