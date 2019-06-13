package ru.kravchenko.ee.servlettest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@WebServlet(urlPatterns = "mega")
public class MegaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", "Hello");
        req.setAttribute("date", new Date());
        req.setAttribute("records", getValues());
//        req.setAttribute("testList", getList());

          req.getRequestDispatcher("mega.jsp").forward(req, resp);
    }




    public List<String> getValues() { return Arrays.asList("aaa", "bbb", "ccc"); }

    //    private List<String> getList() { return Arrays.asList("test - 1", "test - 2", "test - 3"); }
}
