package ServletTestDemo;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstSevletTest extends HttpServlet{
    private String message;

    @Override
    public void init() throws ServletException{
        message = "{\"sessionId\":\"B93BC32DA5654ADE1D0CA165E3D1BE3E\",\"success\":true,\"listdata\":[{\"cl_time\":\"2018-06-28 09:57:38\",\"apprecord\":\"false\"}]}\n";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        resp.setContentType("text/json");
        PrintWriter out = resp.getWriter();
        out.println(message);
    }


}