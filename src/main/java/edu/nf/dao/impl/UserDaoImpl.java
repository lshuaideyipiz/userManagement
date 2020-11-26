package edu.nf.dao.impl;

import edu.nf.dao.UserDao;
import edu.nf.entity.User;
import edu.nf.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author LZ
 * @date 2020/11/25
 */
public class UserDaoImpl implements UserDao {
    public List<User> listUser() {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)){
            return sqlSession.getMapper(UserDao.class).listUser();
        }catch (Exception e){
           throw e;
        }
    }

    public void addUser(User user) {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)) {
            sqlSession.getMapper(UserDao.class).addUser(user);
        }catch (Exception e){
            throw e;
        }
    }
}
