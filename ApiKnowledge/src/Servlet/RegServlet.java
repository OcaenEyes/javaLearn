package Servlet;

import entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/userinfo")
public class RegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Users users = new Users();
        String username,password,gender,email,introduce,accept;
        Date birthday;
        String[] favorite;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("接收到表单提交请求");
        try {
            username = req.getParameter("username");
            password = req.getParameter("password");
            gender = req.getParameter("gender");
            email = req.getParameter("email");
            introduce = req.getParameter("introduce");
            birthday = sdf.parse(req.getParameter("birthday"));
            favorite = req.getParameterValues("favorite");
            if(req.getParameterValues("accept") != null){
                accept = req.getParameter("accept");
            }
            else {
                accept = "false";
            }

            users.setUsername(username);
            users.setPassword(password);
            users.setEamil(email);
            users.setGender(gender);
            users.setFavorite(favorite);
            users.setIntroduce(introduce);
            users.setBirthday(birthday);
            if(accept.equals("true")){
                users.setAccept(true);
            }else {
                users.setAccept(false);
            }

            //把注册的新保存在session中
            req.getSession().setAttribute("regUser",users);

            req.getRequestDispatcher("/userinfo.jsp").forward(req,resp);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
