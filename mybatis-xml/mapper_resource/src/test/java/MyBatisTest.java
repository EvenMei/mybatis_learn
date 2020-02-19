import com.meiyukai.dao.IUserDao;
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
    private IUserDao mapper = null;

    @Before
    public void init() {
        try {
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
            ssfb = new SqlSessionFactoryBuilder();
            factory = ssfb.build(is);
            sqlSession = factory.openSession(true);
            mapper = sqlSession.getMapper(IUserDao.class);
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


    /**
     * 查询所有的用户信息
     * @throws Exception
     */

    @Test
    public void testFindAll() throws Exception {
        List<User> list = mapper.findAll();
        for (User user : list) {
            System.out.println("user == " + user);
        }
    }


    /**
     * 根据id 查询用户信息
     */
    @Test
    public void testFindOne(){
        User user = mapper.findUserById(8);
        System.out.println("user  :   "+ user );

        User user2 = mapper.findUserById(8);
        System.out.println("user2222  :   "+ user );

    }

    /**
     * 添加一个用户
     */
    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("test_01");
        user.setName("test_name");
        user.setPassword("11111");
        mapper.addUser(user);
    }


    /**
     * 更新用户
     */

    @Test
    public void updateUser(){
        User user = mapper.findUserById(6);
        user.setName("Test_user_name");
        mapper.updateUser(user);
    }


    /**
     * 根据ID删除用户
     */

    @Test
    public void testDeleteUser(){
        mapper.deleteUserById(5);
    }


    /**
     * 根据用户的姓名查询用户的信息
     */

    @Test
    public void testFindByUserName(){
        List<User> users = mapper.findByUserName("梅");
        for(User user:users){
            System.out.println("user   :  "+ user );
        }
    }


    @Test
    public void testFindUsersAndAccount(){
        List<User>  users = mapper.findAllUsersAndAccounts();
        for (User user : users){
            List<Account> accounts = user.getAccounts();
            System.out.println("user   :   " + user);
            for(Account account  : accounts){
                System.out.println("account  :  " + account);
            }

            System.out.println("---------------------------------------------------------------");
        }
    }




    @Test
    public void testFindUsersAndAccount2(){
        List<User>  users = mapper.findAllUsersAndAccounts2();
        for (User user : users){
            List<Account> accounts = user.getAccounts();
            System.out.println("user   :   " + user);
            for(Account account  : accounts){
                System.out.println("account  :  " + account);
            }

            System.out.println("---------------------------------------------------------------");
        }
    }


    @Test
    public void testFindUsersAndRoles(){
        List<User> users = mapper.findAllUsersAndRoles();
        for (User user : users){
            List<Role> roles  = user.getRoles();
            System.out.println("user    :    "  + user );
            for(Role  role  : roles){
                System.out.println("role  :  " +role );
            }

            System.out.println("-------------------------------------------------");

        }
    }

    @Test
    public void testFindUsersAndRoles2(){
        List<User> users = mapper.findAllUsersAndRoles2();
        for (User user : users){
            List<Role> roles  = user.getRoles();
            System.out.println("user    :    "  + user );
            for(Role  role  : roles){
                System.out.println("role  :  " +role );
            }

            System.out.println("-------------------------------------------------");

        }
    }





}
