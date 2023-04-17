package fr.sauvageb.chat.servlet.secured;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = PreferenceServlet.URL)
public class PreferenceServlet extends HttpServlet {

    public static final String URL = "/secured/preferences";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/preferences.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String color = req.getParameter("colorChoice");
        HttpSession session = req.getSession();
        session.setAttribute("userColor", color);

        resp.sendRedirect(req.getContextPath() + "/secured");
    }
}
