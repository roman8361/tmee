package ru.kravchenko.ee.servlet.project;

import ru.kravchenko.ee.constant.FieldConst;
import ru.kravchenko.ee.repository.ProjectRepository;
import ru.kravchenko.ee.repository.ProjectRepositoryBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/project-remove")
public class ProjectRemoveServlet extends HttpServlet {

    private ProjectRepository projectRepository = ProjectRepositoryBean.INSTANCES;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String projectId = req.getParameter(FieldConst.ID);
        projectRepository.removeById(projectId);
        resp.sendRedirect("project-list");
    }

}
