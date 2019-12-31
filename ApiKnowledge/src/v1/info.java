package v1;
import DB.DBConn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class info implements infoInterface{
    private ResultSet rs = null;

    @Override
    public List<infoModel> getInfoAll() {
        List<infoModel> list = new ArrayList<infoModel>();
        try{
            DBConn.init();
            rs = DBConn.selectSQL("SELECT * FROM YOUONE");
            while (rs.next()){
                infoModel infomodel = new infoModel();
                infomodel.setId(rs.getInt("id"));
                infomodel.setImgUrl(rs.getString("imhUrl"));
                infomodel.setImgAuther(rs.getString("imgAuther"));
                infomodel.setTextNum(rs.getString("textNum"));
                infomodel.setTextContent(rs.getString("textContent"));
                infomodel.setMon(rs.getString("mon"));
                infomodel.setDay(rs.getString("day"));

                list.add(infomodel);
            }
            DBConn.closeConn();
            return list;
        }catch (SQLException se){
            se.printStackTrace();
        }
        return null;
    }
}

