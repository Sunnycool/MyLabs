package servlets;


import dao.BookDAO;
import entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class BookListServlet extends HttpServlet {
    public BookDAO bookDAO = new BookDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<Book> allEnterprise = null;

        if (req.getParameter("name") != null) {
            System.out.println(req.getParameter("name"));
            allEnterprise = bookDAO.findByName(req.getParameter("name"));
        } else if (req.getParameter("branch") != null) {
            System.out.println(req.getParameter("branch"));
            allEnterprise = bookDAO.findByBranch(req.getParameter("branch"));
        } else {
            allEnterprise = bookDAO.findAll();
        }

        req.setAttribute("enterprises", allEnterprise);
        req.setAttribute("role", (String)req.getSession().getAttribute("role"));

        req.getRequestDispatcher("./list.jsp").forward(req, resp);
    }

}
