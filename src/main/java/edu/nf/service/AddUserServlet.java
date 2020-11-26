package edu.nf.service;

import com.google.gson.Gson;
import edu.nf.dao.UserDao;
import edu.nf.dao.impl.UserDaoImpl;
import edu.nf.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LZ
 * @date 2020/11/25
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int pwd = Integer.parseInt(req.getParameter("pwd"));
        User user = new User(name,pwd);
        UserDao userDao = new UserDaoImpl();
        userDao.addUser(user);
        resp.getWriter().println("成功");
    }
}
