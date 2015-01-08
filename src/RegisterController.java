/**
 * Created by Gagandeep.Singh on 1/8/2015.
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request , HttpServletResponse response)
        throws ServletException , IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("user");
        String password = request.getParameter("pwd");

        LoginBean bean = new LoginBean();
        bean.setName(name);
        bean.setPassword(password);
        request.setAttribute("bean", bean);
        boolean status = bean.register();
        if(!status){
            out.print("<h4>User ID Already Exists<h4>");
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.include(request , response);
        } else {
            out.print("<h4>Registration Successful<h4>");
            RequestDispatcher rd = request.getRequestDispatcher("login-success.jsp");
            rd.include(request , response);
        }

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
