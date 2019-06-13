package ru.kravchenko.ee.servlet.user;

import ru.kravchenko.ee.entity.User;
import ru.kravchenko.ee.repository.UserRepositoryBean;

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

@WebServlet(urlPatterns = {"/authorization"})
public class AuthorizationServlet extends HttpServlet {

    private UserRepositoryBean userRepository = UserRepositoryBean.INSTANCES;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final User currentUser = new User();
        currentUser.setLogin(req.getParameter("login"));
        currentUser.setPassword(req.getParameter("password"));
        final HttpSession httpSession = req.getSession();
        httpSession.setAttribute("user", currentUser);

        if (userRepository.loginExist(req.getParameter("login"))) {
            req.getRequestDispatcher("WEB-INF/views/main.jsp").forward(req, resp);
            return;
        }
        System.out.println("LOGIN NOT FOUND");
        resp.getWriter().println("LOGIN NOT FOUND, TRY AGAIN");
    }

}
