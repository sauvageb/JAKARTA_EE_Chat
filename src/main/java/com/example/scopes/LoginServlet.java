package com.example.scopes;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("boris") && password.equals("boris")) {
            HttpSession session = req.getSession();
            session.setAttribute("username", "boris");
            resp.sendRedirect(req.getContextPath() + "/secured");
        } else {
            req.setAttribute("isError", true);

            req
                    .getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(req, resp);
        }

    }
}
