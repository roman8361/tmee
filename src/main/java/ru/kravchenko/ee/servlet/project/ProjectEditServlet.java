package ru.kravchenko.ee.servlet.project;

import ru.kravchenko.ee.constant.FieldConst;
import ru.kravchenko.ee.entity.Project;
import ru.kravchenko.ee.repository.ProjectRepository;
import ru.kravchenko.ee.repository.ProjectRepositoryBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/project-edit")
public class ProjectEditServlet extends HttpServlet {

    private ProjectRepository projectRepository = ProjectRepositoryBean.INSTANCES;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String projectId = req.getParameter(FieldConst.ID);
        final Project project = projectRepository.findById(projectId);
        if (project == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        req.setAttribute(FieldConst.PROJECT, project);
        req.getRequestDispatcher("WEB-INF/views/project-edit.jsp").forward(req, resp);
    }

}
