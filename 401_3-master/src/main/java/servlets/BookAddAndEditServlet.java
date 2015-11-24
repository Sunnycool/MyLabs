package servlets;

import dao.BookDAO;
import models.Book;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class BookAddAndEditServlet extends HttpServlet {
    @EJB
    public BookDAO bookDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id") != null){
            int id = Integer.valueOf(req.getParameter("id"));
            Book enterprise = bookDAO.read(id);

            req.setAttribute("enterprise", enterprise);
        }

        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String branch = req.getParameter("branch");
        int employeeCount = Integer.valueOf(req.getParameter("employeeCount"));

        Book enterprise = null;

        if (!req.getParameter("id").equals("")) {
            int id = Integer.valueOf(req.getParameter("id"));

            enterprise = bookDAO.read(id);
            enterprise.setName(name);
            enterprise.setBranch(branch);
            enterprise.setEmployeeCount(employeeCount);
            bookDAO.update(enterprise);
        } else {
            enterprise = new Book(name, branch, employeeCount);
            bookDAO.create(enterprise);
        }
        resp.sendRedirect("list");
    }
}
