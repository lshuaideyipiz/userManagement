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
 * @date 2020/12/16
 */
@WebServlet("/selUserServlet")
public class SelUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("selName");
        UserDao dao = new UserDaoImpl();
        User user = dao.selUserByName(name);
        String json = new Gson().toJson(user);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println(json);
    }
}
