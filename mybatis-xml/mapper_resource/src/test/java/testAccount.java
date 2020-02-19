import com.meiyukai.dao.IAccountDao;
import com.meiyukai.dao.IUserDao;
import com.meiyukai.domain.Account;
import com.meiyukai.domain.User;
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
    private IAccountDao mapper = null;

    @Before
    public void init() {
        try {
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
            ssfb = new SqlSessionFactoryBuilder();
            factory = ssfb.build(is);
            sqlSession = factory.openSession(true);
            mapper = sqlSession.getMapper(IAccountDao.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindAllAccount(){
        List<Account> accounts = mapper.findAll();
        for(Account account : accounts){

            System.out.println("account :  " + account);
        }
    }

    @Test
    public void testFindAccountById(){
        Account account  = mapper.findAccountById(2);
        System.out.println("account  :  "  + account);
    }


    @Test
    public void testFindAccountsAndUser(){
        List<Account> accounts = mapper.findAccountsAndUser();
        for (Account  account :accounts){
            User user = account.getUser();
            System.out.println("account  :  " + account);
            System.out.println("user  :  " +  user);
            System.out.println("-------------------------------------------------------");
        }
    }

    @Test
    public void testFindAccountsAndUser2(){
        List<Account> accounts = mapper.findAccountsAndUser2();
        for (Account  account :accounts){
            User user = account.getUser();
            System.out.println("account  :  " + account);
            System.out.println("user  :  " +  user);
            System.out.println("-------------------------------------------------------");
        }
    }










}
