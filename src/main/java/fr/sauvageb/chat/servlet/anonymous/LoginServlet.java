package fr.sauvageb.chat.servlet.anonymous;

import fr.sauvageb.chat.model.User;
import fr.sauvageb.chat.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = LoginServlet.URL)
public class LoginServlet extends HttpServlet {

    public static final String URL = "/login";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserService userService = new UserService();
        User user = userService.login(username, password);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("username", user.getUsername());
            resp.sendRedirect(req.getContextPath() + "/secured");
        } else {
            req.setAttribute("isError", true);

            req
                    .getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(req, resp);
        }

    }
}
