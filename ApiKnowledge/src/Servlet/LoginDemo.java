package Servlet;

import entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Users user =new Users();

        String uname = req.getParameter("username");
        String pass = req.getParameter("password");
        user.setUsername(uname);
        user.setPassword(pass);

        //判断用户名密码是都正确
        if (user.getUsername().equals("admin") && user.getPassword().equals("admin")){
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.print("login sucess");
            out.flush();
        }else {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.print("login fail");
            out.flush();
        }
    }
}
