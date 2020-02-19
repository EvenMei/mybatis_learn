import com.meiyukai.dao.IUserDao;
import com.meiyukai.domain.User;
import com.meiyukai.mapper.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 测试mybatis
 */
public class MyBatisTest {
    private InputStream is = null;
    private SqlSessionFactoryBuilder ssfb = null;
    private SqlSession sqlSession = null;
    private SqlSessionFactory factory = null;
//    private IUserDao mapper = null;
    private UserDao mapper;

    @Before
    public void init() {
        try {
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
            ssfb = new SqlSessionFactoryBuilder();
            factory = ssfb.build(is);
            sqlSession = factory.openSession(true);
            mapper = sqlSession.getMapper(UserDao.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @After
    public void destory() throws Exception {
        // sqlSession.close();
        //is.close();
//        System.out.println("=======" + "sqlSession and inputStream is closed ... ");
    }

    @Test
    public void testFindAll() throws Exception {

        List<User> list = mapper.findAll();
        for (User user : list) {
            System.out.println("user == " + user);
        }
    }


    @Test
    public void testFindUserById(){
        User user = mapper.findUserById(2);
        System.out.println("user  :  " + user);
    }

    @Test
    public void testFindUserByName(){
        List<User> users = mapper.findUserByName("mei");
        for (User user : users){
            System.out.println("user  :  " + user);
        }
    }

    @Test
    public void testAddUser(){
        User user = new User();
        user.setName("meimei");
        user.setPassword("mei112233");
        user.setUsername("梅梅");
        mapper.addUser(user);
    }

    @Test
    public void testDeleteUser(){
        mapper.deleteUserById(9);
    }

    @Test
    public void testUpdateUser(){
        User user = mapper.findUserById(8);
        System.out.println("before update :  "+ user);
        user.setPassword("666666");
        mapper.updateUser(user);
        System.out.println("after update : "+ mapper.findUserById(8));
    }









}
