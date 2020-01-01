package com.gzy.page.servlet;

import com.google.gson.Gson;
import com.gzy.page.model.YouoneInfo;
import com.gzy.page.model.YouoneInfoPage;
import com.gzy.page.service.YouoneInfoService;
import com.gzy.page.service.YouoneInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getInfoBySublist")
public class SublistServlet extends HttpServlet {
    private static final long serialVersionUID = 8607214210636009639L;
    private YouoneInfoService youoneInfoService = new YouoneInfoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收request 参数
        String textNumStr = req.getParameter("textNum");
        String textNum = "VOL" + "." + textNumStr;
        String pageSizeStr = req.getParameter("pageSize");
        int pageSize = Integer.parseInt(pageSizeStr);
        String pageNumStr = req.getParameter("pageNum");
        int pageNum = Integer.parseInt(pageNumStr);

        //组装查询条件
        YouoneInfo searchModel = new YouoneInfo();
        searchModel.setTextNum(textNum);

        // 调用service获取查询结果
        YouoneInfoPage<YouoneInfo> result = youoneInfoService.findInfo(searchModel,pageNum,pageSize);

        // 返回查询结果到页面
        Gson gson = new Gson();
        String json = gson.toJson(result);

        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();


    }
}
