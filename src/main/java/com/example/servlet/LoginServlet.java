package com.example.servlet;

import com.example.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
        else{
            response.sendRedirect(request.getContextPath() + "/user/hello.jsp");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        boolean isPasswordPresent = !(request.getParameter("password").isEmpty());
        int loginFlag=0;
        List<String> users = Users.getInstance().getUsers();
        for (String logins:users) {
            if(login.equals(logins)) {
                loginFlag=1;
                break;
            }
        }
        if(loginFlag==1 && isPasswordPresent==true){
            session.setAttribute("user", login);
            response.sendRedirect(request.getContextPath() + "/user/hello.jsp");
        }
        else{
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
