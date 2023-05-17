package fr.sauvageb.chat.servlet.secured;

import fr.sauvageb.chat.service.ChatMessageService;
import fr.sauvageb.chat.servlet.secured.DashboardServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/secured/chat/add")
public class ChatServlet extends HttpServlet {

    private static ChatMessageService chatMessageService = new ChatMessageService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");

        HttpSession session = req.getSession();
        String usernameConnected = (String) session.getAttribute("username");

        boolean isSent = chatMessageService.addChat(message, usernameConnected);
        resp.sendRedirect(req.getContextPath() + DashboardServlet.URL);
    }
}
