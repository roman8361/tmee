package ru.kravchenko.ee.servlet.task;

import org.jetbrains.annotations.Nullable;
import ru.kravchenko.ee.constant.FieldConst;
import ru.kravchenko.ee.entity.Task;
import ru.kravchenko.ee.entity.User;
import ru.kravchenko.ee.repository.TaskRepository;
import ru.kravchenko.ee.repository.TaskRepositoryBean;
import ru.kravchenko.ee.repository.UserRepository;
import ru.kravchenko.ee.repository.UserRepositoryBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

@WebServlet(urlPatterns = "/task-list")
public class TaskListServlet extends HttpServlet {

    private TaskRepository taskRepository = TaskRepositoryBean.INSTANCES;

    private UserRepository userRepository = UserRepositoryBean.INSTANCES;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession httpSession = req.getSession();
        if (checkSession(httpSession)) {
            final Collection<Task> tasks = taskRepository.findAll();
            req.setAttribute(FieldConst.TASKS, tasks);
            req.getRequestDispatcher("WEB-INF/views/task-list.jsp").forward(req, resp);
            return;
        }
        req.getRequestDispatcher("WEB-INF/views/session-not-found.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private boolean checkSession(@Nullable final HttpSession httpSession) {
        if (httpSession == null) return false;
        @Nullable final User user = (User) httpSession.getAttribute("user");
        if (user == null) return false;
        return userRepository.loginExist(user.getLogin());
    }

}
