package com.example.scopes;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/secured")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
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

        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}
