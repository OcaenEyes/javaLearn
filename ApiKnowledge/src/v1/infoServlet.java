package v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        if(page ==null || page.equals("0")){
            if(list1.size() > 9){
                for (int i=0;i<1;i++){
                    infolist.add(list1.get(i));
                }
            }
            else {
                for(int i=0;i<list1.size();i++){
                    infolist.add(list1.get(i));
                }
            }
        }
    }
}
