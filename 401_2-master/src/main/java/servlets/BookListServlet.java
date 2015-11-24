package servlets;


import dao.BookDAO;
import models.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class BookListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<Book> allBook = null;

        if (req.getParameter("name") != null) {
            System.out.println(req.getParameter("name"));
            allBook = BookDAO.findByName(req.getParameter("name"));
        } else if (req.getParameter("branch") != null) {
            System.out.println(req.getParameter("branch"));
            allBook = BookDAO.findByAuthor(req.getParameter("branch"));
        } else {
            allBook = BookDAO.findAll();
        }

        req.setAttribute("enterprises", allBook);

        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }

}
