package edu.nf.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author LZ
 * @date 2020/11/25
 */
public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try{
            InputStream is = Resources.getResourceAsStream("mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(boolean b){return sqlSessionFactory.openSession(b);}
}
