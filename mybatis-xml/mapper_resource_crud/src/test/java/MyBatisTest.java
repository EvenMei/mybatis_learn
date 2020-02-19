import com.meiyukai.dao.IUserDao;
import com.meiyukai.domain.User;
import com.meiyukai.pojo.QueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
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
        System.out.println("=======" + "sqlSession and inputStream is closed ... ");
    }

    @Test
    public void testFindAll() throws Exception {

        List<User> list = mapper.findAll();
        for (User user : list) {
            System.out.println("user == " + user);
        }

    }

    @Test
    public void testInsert() throws Exception {
        User user = new User(null, "周11", "三牌楼", new Date(), "2");
        mapper.saveUser(user);
        System.out.println("user =  " + user);

    }

    @Test
    public void testUpdate() {
        User user = mapper.getUserById(38);
        System.out.println("==== before ====" + user);
        user.setUsername("周六");
        mapper.updateUser(user);
        System.out.println("==== after ==== " + mapper.getUserById(38));
    }


    @Test
    public void testDeleteUserById() {
        System.out.println("====删除之前共有" + mapper.getCount());
        mapper.deleteUserById(26);
        System.out.println("====删除之后有" + mapper.getCount());
    }


    @Test
    public void testFindByUsername() {
        List<User> list = mapper.findByUserName("a");
        for (User user : list) {
            System.out.println("user === " + user);
        }
    }

    @Test
    public void testfindByQueryVo() {
        QueryVo vo = new QueryVo();
        vo.setName("a");
        List<User> users = mapper.findByQueryVo(vo);
        for (User user : users) {
            System.out.println("===user" + user);
        }
    }

    @Test
    public void testFindInIds(){
        QueryVo vo = new QueryVo();
        Integer[] ids = new Integer[]{22,34,40,41,1,31,32,33};
        vo.setIds(Arrays.asList(ids));
        List<User> users = mapper.findUserInIds(vo);
        for(User user:users){
            System.out.println("user === " + user);
        }
    }


}
