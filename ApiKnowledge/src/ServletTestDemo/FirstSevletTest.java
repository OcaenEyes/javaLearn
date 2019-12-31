package ServletTestDemo;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstSevletTest extends HttpServlet{
    private String getmessage;
    private String postmessage;

    @Override
    public void init() throws ServletException{
        getmessage = "{\"sessionId\":\"get\",\"success\":true,\"listdata\":[{\"cl_time\":\"2018-06-28 09:57:38\",\"apprecord\":\"false\"}]}\n";
        postmessage = "{\"sessionId\":\"post\",\"success\":true,\"listdata\":[{\"cl_time\":\"2018-06-28 09:57:38\",\"apprecord\":\"false\"}]}\n";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        System.out.println("处理get请求");
        resp.setContentType("text/json");
        PrintWriter out = resp.getWriter();
        out.println(getmessage);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("处理post请求");
        resp.setContentType("text/json");
        PrintWriter out = resp.getWriter();
        out.println(postmessage);
    }
}