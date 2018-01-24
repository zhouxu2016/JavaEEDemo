package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhouxu
 * Created by zhouxu on 2017/10/9 15:24.`
 */
@WebServlet(name = "DemoServlet", urlPatterns = "/DemoServlet")
public class DemoServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//suspicious
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("doGet>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("doGet>>>>>>>>>>>>>>>>>>>>>>");

    }

}
