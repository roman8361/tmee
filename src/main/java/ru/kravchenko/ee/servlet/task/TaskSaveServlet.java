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

@WebServlet(urlPatterns = "/task-save")
public class TaskSaveServlet extends HttpServlet {

    private TaskRepository taskRepository = TaskRepositoryBean.INSTANCES;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter(FieldConst.ID);
        if (id == null || id.isEmpty()) {
            sendRedirectTaskList(resp);
            return;
        }
        final Task task = taskRepository.findById(id);
        if (task == null) {
            sendRedirectTaskList(resp);
            return;
        }
        task.setName(req.getParameter(FieldConst.NAME));
        task.setDescription(req.getParameter(FieldConst.DESCRIPTION));
        taskRepository.merge(task);
        sendRedirectTaskList(resp);
    }

    private void sendRedirectTaskList(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("task-list");
    }

}
