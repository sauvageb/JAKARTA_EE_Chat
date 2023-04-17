package fr.sauvageb.chat.servlet.secured;

import fr.sauvageb.chat.model.User;
import fr.sauvageb.chat.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = UserProfilServlet.URL)
public class UserProfilServlet extends HttpServlet {

    public static final String URL = "/secured/profil";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        HttpSession session = req.getSession();
        String usernameConnected = (String) session.getAttribute("username");
        User user = userService.fetchUserByUsername(usernameConnected);

        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/profil.jsp").forward(req, resp);
    }

}
