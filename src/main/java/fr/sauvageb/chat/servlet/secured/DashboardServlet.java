package fr.sauvageb.chat.servlet.secured;

import fr.sauvageb.chat.model.ChatMessage;
import fr.sauvageb.chat.model.User;
import fr.sauvageb.chat.service.ChatMessageService;
import fr.sauvageb.chat.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = DashboardServlet.URL)
public class DashboardServlet extends HttpServlet {

    public static final String URL = "/secured";

    private static UserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        User user = userService.fetchUserByUsername(username);
        req.setAttribute("currentUser", user);

        ChatMessageService chatMessageService = new ChatMessageService();
        List<ChatMessage> messages = chatMessageService.fetchAllMessages();
        req.setAttribute("messages", messages);

//        List<ChatMessage> messages = new ArrayList<>(Arrays.asList(
//                new ChatMessage(1L, "Hi", boris),
//                new ChatMessage(2L, "What are you doing tomorrow? Can we come up a bar?", boris),
//                new ChatMessage(3L, "Hiii, I'm good.", null),
//                new ChatMessage(3L, "Long time no see! Tomorrow office. will be free on sunday.", null),
//                new ChatMessage(3L, "Okay", boris),
//                new ChatMessage(3L, "We will go on Sunday?", boris)
//        ));

        req.getRequestDispatcher("/WEB-INF/chat.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Recuperation du prenom depuis le formulaire
        String firstnameValue = req.getParameter("firstnameInput");
        // Recuperation de la session de l'utilisateur qui navigue sur / (identifiable par son JSSESSION_ID stocké dans ses cookies)
        HttpSession session = req.getSession();
        // Création d'une liste vide
        List<String> history = new ArrayList<>();
        // Si une liste contenant les utilisateurs est présente dans la session, utilisation de cette liste
        if (session.getAttribute("users") != null) {
            history = (List<String>) session.getAttribute("users");
        }
        // Ajoute l'utilisateur dans la liste
        history.add(firstnameValue);
        // Ajoute la liste dans la session
        session.setAttribute("users", history);

        // Scope HttpServletRequest => durée d'une requete (Transmettre temporairement de la données. Servlet <==> JSP )
        // Scope HttpSession => durée d'une session (Panier)
        // Scope ServletContext => durée de l'application (Nombre de visiteurs, de pages vues ...stats)

        req.getRequestDispatcher("/WEB-INF/chat.jsp").forward(req, resp);
    }
}
