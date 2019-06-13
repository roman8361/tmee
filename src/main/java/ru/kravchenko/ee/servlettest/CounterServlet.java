package ru.kravchenko.ee.servlettest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Roman Kravchenko
 */

@WebServlet(urlPatterns = {"/counter"})
public class CounterServlet extends HttpServlet {

    private static final String COUNTER = "COUNTER";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session = req.getSession();
        final Object counter = session.getAttribute(COUNTER);
        final Long valueOld = counter == null ? 0 : Long.parseLong(counter.toString());
        final Long valueNew = valueOld + 1;
        req.getSession().setAttribute(COUNTER, valueNew);
        resp.getWriter().println(valueOld);
    }

}
