package fr.sauvageb.chat.servlet.anonymous;

import fr.sauvageb.chat.exception.UserAlreadyExistException;
import fr.sauvageb.chat.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = RegisterServlet.URL)
public class RegisterServlet extends HttpServlet {

    public static final String URL = "/register";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        req.setAttribute("firstname", firstname);
        req.setAttribute("lastname", lastname);
        req.setAttribute("username", username);
        req.setAttribute("email", email);

        boolean isInvalid = firstname.isBlank() || lastname.isBlank() || username.isBlank() || password.isBlank() || email.isBlank();
        if (isInvalid) {
            req.setAttribute("form_validation_error", true);
        } else {
            try {
                UserService userService = new UserService();
                userService.register(username, firstname, lastname, email, password, "");
                resp.sendRedirect(req.getContextPath() + LoginServlet.URL);
                return;
            } catch (UserAlreadyExistException e) {
                req.setAttribute("duplicate_user_error", true);
            } catch (Exception e) {
                req.setAttribute("register_error", true);
                req.setAttribute("firstname", firstname);
                req.setAttribute("lastname", lastname);
                req.setAttribute("username", username);
                req.setAttribute("email", email);
            }
        }
        req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
    }
}
