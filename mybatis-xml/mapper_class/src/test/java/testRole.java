import com.meiyukai.dao.AccountDao;
import com.meiyukai.dao.RoleDao;
import com.meiyukai.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class testRole {

    private InputStream is = null;
    private SqlSessionFactoryBuilder ssfb = null;
    private SqlSession sqlSession = null;
    private SqlSessionFactory factory = null;
    private RoleDao mapper = null;

    @Before
    public void init() {
        try {
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
            ssfb = new SqlSessionFactoryBuilder();
            factory = ssfb.build(is);
            sqlSession = factory.openSession(true);
            mapper = sqlSession.getMapper(RoleDao.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testFindAllRoles(){
        List<Role> roles = mapper.findAllRoles();
        for(Role role: roles){
            System.out.println("role  :  " + role);
        }
    }

    @Test
    public void testFindRoleById(){
        Role role = mapper.findRoleById(1);
        System.out.println("role  :  "  + role);
    }
}
