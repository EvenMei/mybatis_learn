import com.meiyukai.dao.AccountDao;
import com.meiyukai.dao.UserDao;
import com.meiyukai.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class testAccount {
    private InputStream is = null;
    private SqlSessionFactoryBuilder ssfb = null;
    private SqlSession sqlSession = null;
    private SqlSessionFactory factory = null;
    private AccountDao mapper = null;

    @Before
    public void init() {
        try {
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
            ssfb = new SqlSessionFactoryBuilder();
            factory = ssfb.build(is);
            sqlSession = factory.openSession(true);
            mapper = sqlSession.getMapper(AccountDao.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testFindAccountById(){
        Account account   =  mapper.findAccountById(1);
        System.out.println("account :  "+  account );
    }


    @Test
    public void testFindAllAccounts(){
        List<Account> accounts  =  mapper.findAllAccounts();
        for (Account account : accounts){
            System.out.println("account : " + account);
            System.out.println("user : " + account.getUser());
            System.out.println("-----------------------------------------------------------------------------");
        }
    }

}
