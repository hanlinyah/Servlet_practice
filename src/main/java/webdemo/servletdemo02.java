package webdemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;


@WebServlet(urlPatterns = "/demo02",loadOnStartup = 1)
public class servletdemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getMethod());
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));
        String[] habbys=req.getParameterValues("hobby");
        if(habbys !=null) {
            for (String habby : habbys) {
                System.out.println(habby);
            }
        }
        req.setAttribute("msg","hahaha");
        //請求轉發
        req.getRequestDispatcher("/demo03").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        BufferedReader br=req.getReader();
//        String line =br.readLine();
//        System.out.println(line);
//        req.setCharacterEncoding("UTF-8");
//        System.out.println(req.getMethod());
//        System.out.println(req.getQueryString());
//        System.out.println(req.getParameter("username"));
//        System.out.println(req.getParameter("password"));
//        System.out.println(req.getParameter("hobby"));
        doGet(req,resp);
    }
}
