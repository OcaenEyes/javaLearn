package v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class infoServlet extends HttpServlet {
    private static final long serialVersionUID =1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        info infodetial = new info();
        List<infoModel> list = infodetial.getInfoAll();
        List<infoModel> list1 = new ArrayList<>();
        int size = list.size();
        infoModel infomodel;

        for(int i=0;i<size;i++){
            infomodel = new infoModel();
            infomodel.setId(list.get(i).getId());
            infomodel.setImgUrl(list.get(i).getImgUrl());
            infomodel.setImgAuther(list.get(i).getImgAuther());
            infomodel.setTextNum(list.get(i).getTextNum());
            infomodel.setTextContent(list.get(i).getTextContent());
            infomodel.setMon(list.get(i).getMon());
            infomodel.setDay(list.get(i).getDay());
            list1.add(infomodel);
        }

        String page = req.getParameter("page");
        List<infoModel> infolist = new ArrayList<infoModel>();
//https://blog.csdn.net/qq_31242531/article/details/80497940


        //分页
        if (page == null || page.equals("0")) {
            if (list1.size() > 9) {
                for (int i = 0; i < 10; i++) {
                    infolist.add(list1.get(i));
                }
            } else {
                for (int i = 0; i < list1.size(); i++) {
                    infolist.add(list1.get(i));
                }
            }
        } else {
            int infoSize = list1.size();
            int pageCount = infoSize / 10;

            int pageNum = Integer.parseInt(page);
            if (pageNum < pageCount) {
                for (int i = 10 * pageNum; i < 10 * pageNum + 10; i++) {
                    infolist.add(list1.get(i));
                }
            } else {
                for (int i = 10 * pageNum; i < list1.size(); i++) {
                    infolist.add(list1.get(i));
                }
            }
        }

        infoModelPage nt = new infoModelPage(infolist.size(),infolist);

        Gson gson = new Gson();
        String json = gson.toJson(nt);

        //输出界面
        System.out.println(json);
        resp.setContentType("text/json");
        PrintWriter out = new PrintWriter(resp.getOutputStream());
        out.print(json);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
