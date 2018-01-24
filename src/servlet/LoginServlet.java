package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhouxu on 2017/11/5 20:03.
 */
//@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("doGet>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("doGet>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("doGet>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("doGet>>>>>>>>>>>>>>>>>>>>>>");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("doPost>>>>>>>>>>>>>>>>>>>>>>");

    }
}
