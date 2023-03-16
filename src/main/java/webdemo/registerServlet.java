package webdemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapper.UserMapper;
import pojo.User;
import util.getSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class registerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        UserMapper userMapper=getSession.getUserMapper();
        User user= userMapper.selectByUsername(username);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer=resp.getWriter();
        if(user!= null){
            writer.write("<h1>用戶名稱已存在</h1>");
            writer.write("<a href=\"html/register.html\">重新註冊</a>");
        }else{
            userMapper.insert(new User(username,password));
            writer.write("<h1>註冊成功，您的用戶名稱是："+username+"</h1>");
            writer.write("<a href=\"html/login.html\">前往登入</a>");
        };
        getSession.closeSession();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
