package servlets;

import com.jcraft.jsch.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public final String ADMIN_LOGIN = "admin";
    public final String USER_LOGIN = "user";
    public final String ADMIN_PASSWORD = "1234";
    public final String USER_PASSWORD = "1234";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        System.out.println("login " + login);
        System.out.println("password " + password);

        if (login.equals(ADMIN_LOGIN) && password.equals(ADMIN_PASSWORD)) {
            HttpSession s = req.getSession();
            s.setAttribute("role", "admin");
            resp.sendRedirect("list");
        } else if (login.equals(USER_LOGIN) && password.equals(USER_PASSWORD)) {
            HttpSession s = req.getSession();
            s.setAttribute("role", "user");
            resp.sendRedirect("list");
        } else {
            resp.sendRedirect("login");
        }

    }
}
