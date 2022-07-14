package com.cognixia.jump.menu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.exception.PWLimitException;

public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            String username = req.getParameter("user_name").trim().toLowerCase();
            String password = req.getParameter("password").trim();

            PrintWriter pw = res.getWriter();

            if (password.length() < 4) {
                throw new PWLimitException("Password length is too small.");
            } else if (username.isEmpty() && password.isEmpty()) {
                throw new LoginException("Must enter username and password");
            } else {
                System.out.println("Good password!!");
            }
        } catch (PWLimitException e) {
            e.printStackTrace();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
