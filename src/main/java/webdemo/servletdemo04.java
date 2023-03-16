package webdemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo04")
public class servletdemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo04");
//        System.out.println(System.getProperty("user.dir"));
//        FileInputStream fis=new FileInputStream("C:/apache-tomcat-10.1.7/webapps/servlet_practice_war/img/testimage.png");
        FileInputStream fis=new FileInputStream("../webapps/servlet_practice_war/img/testimage.png");
        ServletOutputStream os=resp.getOutputStream();
        IOUtils.copy(fis,os);


//        byte[] buff=new byte[1024];
//        int len=0;
//        while ((len=fis.read(buff))!=-1){
//            os.write(buff,0,len);
//        }
        fis.close();
//        resp.setHeader("content-type","text/html");
//        resp.setContentType("text/html;charset=utf-8");
//        PrintWriter writer=resp.getWriter();
//        writer.write("<h1>aaa</h1>");
//        writer.write("<h1>您好</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
