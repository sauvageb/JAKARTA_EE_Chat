package fr.sauvageb.chat.filter;


import fr.sauvageb.chat.servlet.secured.LogoutServlet;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

import java.io.IOException;

@WebFilter(urlPatterns = LogoutServlet.URL)
public class CounterLogoutFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        ServletContext context = req.getServletContext();

        int counter = 0;
        if (context.getAttribute("counter_logout") != null) {
            counter = (int) context.getAttribute("counter_logout");
        }
        context.setAttribute("counter_logout", ++counter);

        System.out.println(context.getAttribute("counter_logout"));

        chain.doFilter(req, res);
    }
}
