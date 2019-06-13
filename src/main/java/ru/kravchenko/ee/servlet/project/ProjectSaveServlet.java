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

@WebServlet(urlPatterns = "/project-save")
public class ProjectSaveServlet extends HttpServlet {

    private ProjectRepository projectRepository = ProjectRepositoryBean.INSTANCES;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter(FieldConst.ID);
        if (id == null || id.isEmpty()) {
            sendRedirectProjectList(resp);
            return;
        }
        final Project project = projectRepository.findById(id);
        if (project == null) {
            sendRedirectProjectList(resp);
            return;
        }
        project.setName(req.getParameter(FieldConst.NAME));
        project.setDescription(req.getParameter(FieldConst.DESCRIPTION));
        projectRepository.merge(project);
        sendRedirectProjectList(resp);
    }

    private void sendRedirectProjectList(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("project-list");
    }

}
