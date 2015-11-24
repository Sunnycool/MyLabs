package servlets;

import dao.BookDAO;

import entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class BookAddAndEditServlet extends HttpServlet {
    public BookDAO bookDAO = new BookDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id") != null){
            int id = Integer.valueOf(req.getParameter("id"));
            Book book = bookDAO.read(id);

            req.setAttribute("enterprise", book);
        }

        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String branch = req.getParameter("branch");
        int employeeCount = Integer.valueOf(req.getParameter("employeeCount"));

        Book  book = null;

        if (!req.getParameter("id").equals("")) {
            int id = Integer.valueOf(req.getParameter("id"));

            book = bookDAO.read(id);
            book.setName(name);
            book.setBranch(branch);
            book.setEmployeeCount(employeeCount);
            bookDAO.update(book);
        } else {
            book = new Book(name, branch, employeeCount);
            bookDAO.create(book);
        }
        resp.sendRedirect("list");
    }
}
