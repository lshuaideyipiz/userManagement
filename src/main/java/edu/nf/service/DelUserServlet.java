package edu.nf.service;

import com.google.gson.Gson;
import edu.nf.dao.UserDao;
import edu.nf.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LZ
 * @date 2020/12/15
 */
@WebServlet("/delServlet")
public class DelUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        try {
            String name = req.getParameter("userName");
            System.out.println(name);
            UserDao dao = new UserDaoImpl();
            dao.delUserByName(name);
            String json = new Gson().toJson("成功");
            resp.getWriter().println(json);
        } catch (Exception e) {
            e.printStackTrace();
            String json = new Gson().toJson("失败");
            resp.getWriter().println(json);
        }

    }
}
