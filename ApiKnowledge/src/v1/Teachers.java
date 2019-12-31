package v1;

import DB.DBConn;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/api/teacher")
public class Teachers extends HttpServlet {
    private ResultSet rs = null;
    private List<TeachersModel> list = new ArrayList<>();

    @Override
    public void init() {
        try {
            DBConn.init();
            rs = DBConn.selectSQL("SELECT * FROM teachers");
            while (rs.next()) {
                TeachersModel teachersModel = new TeachersModel();
                teachersModel.setTno(rs.getInt("tno"));
                teachersModel.setTname(rs.getString("tanme"));
                teachersModel.setTsex(rs.getString("tsex"));
                teachersModel.setTbirthday(rs.getString("tbirthday"));
                teachersModel.setProf(rs.getString("prof"));
                teachersModel.setDepart(rs.getString("depart"));
                list.add(teachersModel);
            }
            DBConn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConn.closeConn();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TeachersModel> list1 = new ArrayList<>();
        int size = list.size();

        for (int i = 0; i < size; i++) {
            TeachersModel tmodel = new TeachersModel();
            tmodel.setTno(list.get(i).getTno());
            tmodel.setTname(list.get(i).getTname());
            tmodel.setTsex(list.get(i).getTsex());
            tmodel.setTbirthday(list.get(i).getTbirthday());
            tmodel.setProf(list.get(i).getProf());
            tmodel.setDepart(list.get(i).getDepart());

            list1.add(tmodel);
        }

        Gson gson = new Gson();
        String json = gson.toJson(list1);

        System.out.println(json);
        resp.setContentType("text/json");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();

    }
}
