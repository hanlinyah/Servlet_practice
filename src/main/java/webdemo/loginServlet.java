package webdemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.User;
import util.getSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User user= getSession.getUserMapper().selectByUsernameAndPassword(new User(username,password));
        getSession.closeSession();
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer=resp.getWriter();

        if(user != null){
            writer.write("<h1>登入成功</h1>");
        }else {
            writer.write("<h1>登入失敗</h1>");
            writer.write("<a href=\"html/login.html\">重新登入</a>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
