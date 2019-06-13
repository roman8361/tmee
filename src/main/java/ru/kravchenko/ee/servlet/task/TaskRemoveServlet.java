package ru.kravchenko.ee.servlet.task;

import ru.kravchenko.ee.constant.FieldConst;
import ru.kravchenko.ee.repository.TaskRepository;
import ru.kravchenko.ee.repository.TaskRepositoryBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/task-remove")
public class TaskRemoveServlet extends HttpServlet {

    private TaskRepository taskRepository = TaskRepositoryBean.INSTANCES;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String taskId = req.getParameter(FieldConst.ID);
        taskRepository.removeById(taskId);
        resp.sendRedirect("task-list");
    }

}
