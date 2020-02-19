import com.meiyukai.dao.UserDao;
import com.meiyukai.domain.Account;
import com.meiyukai.domain.Role;
import com.meiyukai.domain.User;
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
    private UserDao mapper = null;

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
    public void findUserByid(){
        User user = mapper.findUserById(1);
        System.out.println("user  :  " + user);
    }


    @Test
    public void testAddUser(){
        User user  = new User();
        user.setUsername("zhangsan");
        user.setPassword("zhangsan123");
        user.setName("zs");
        mapper.addUser(user);
    }

    @Test
    public void testUpdateUser(){
        User user = mapper.findUserById(7);
        user.setName("nickName_");
        mapper.updateUser(user);
    }

    @Test
    public void testDeleteUserById(){
        mapper.deleteUserById(6);
    }

    @Test
    public void testFindUserByName(){
        String username = "mei";
        List<User> users = mapper.findUserByName(username);
        for(User user  : users){
            System.out.println("user  :  "  + user);
        }
    }


    @Test
    public void testFindCount(){
        Integer count = mapper.findTotalUsers();
        System.out.println("total  :  " + count  );
    }

    @Test
    public void testFindAllUsersAndAccounts(){
        List<User> users  =mapper.findAllUsersAndAccounts();
        for (User user : users) {
            List<Account> accounts = user.getAccounts();
           System.out.println("user ------   "+ user);
           for(Account account : accounts){
               System.out.println("account  ------   "  + account);
           }
           System.out.println("-----------------------------------------------------------------------------------------------");
        }
    }


    @Test
    public void testFindAllUsersAndRoles(){
        List<User> users  =  mapper.findAllUsersAndRoles();
        for(User user : users){
            List<Role> roles = user.getRoles();
            System.out.println("user  :  "  + user );
            for(Role role : roles){
                System.out.println("role  :  " + role);
            }
            System.out.println("--------------------------------------------------------------------------------------------");

        }
    }











}
