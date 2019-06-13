package ru.kravchenko.ee.servlet.task;

import ru.kravchenko.ee.constant.FieldConst;
import ru.kravchenko.ee.entity.Task;
import ru.kravchenko.ee.repository.TaskRepository;
import ru.kravchenko.ee.repository.TaskRepositoryBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/task-edit")
public class TaskEditServlet extends HttpServlet {

    private TaskRepository taskRepository = TaskRepositoryBean.INSTANCES;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String taskId = req.getParameter(FieldConst.ID);
        final Task task = taskRepository.findById(taskId);
        if (task == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        req.setAttribute(FieldConst.TASK, task);
        req.getRequestDispatcher("WEB-INF/views/task-edit.jsp").forward(req, resp);
    }

}
