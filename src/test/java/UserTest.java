import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;
import pojo.User;

import java.io.InputStream;
import java.util.List;

public class UserTest {
    static SqlSession session;
    static UserMapper userMapper;
    @BeforeClass
    public static void beforeclass() throws Exception{

        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        userMapper=session.getMapper(UserMapper.class);
    }

    @AfterClass
    public static void afterclass(){
        session.commit();
        session.close();
    }

    @Test
    public void testselectall() throws Exception {
        List<User> users=userMapper.selectAll();
        System.out.println("查詢結果：");
        System.out.println(users);
    }
    @Test
    public void testselectByUsernameAndPassword() throws Exception {
        String username= "testacc01";
        String password= "password";
        User newuser=new User(username,password);
        User queryuser=userMapper.selectByUsernameAndPassword(newuser);
        System.out.println("查詢結果：");
        System.out.println(queryuser);
    }

    @Test
    public void testselectByUsername() throws Exception {
        String username= "testacc01";
        User queryuser=userMapper.selectByUsername(username);
        System.out.println("查詢結果：");
        System.out.println(queryuser);
    }
    @Test
    public void testinsert() throws Exception {
        String testusername= "testacc03";
        String testpassword= "password";

        User newtestuser=new User(testusername,testpassword);
        userMapper.insert(newtestuser);
        System.out.println("插入數據為："+newtestuser);
    }



}
