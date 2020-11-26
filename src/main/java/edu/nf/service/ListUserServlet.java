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
import java.util.List;

/**
 * @author LZ
 * @date 2020/11/25
 */
@WebServlet("/ListUserServlet")
public class ListUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao dao = new UserDaoImpl();
        List<User> list = dao.listUser();
        String json = new Gson().toJson(list);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println(json);
    }
}
