
import com.lengkai.dao.IUserDao;
import com.lengkai.domain.Queryvo;
import com.lengkai.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 *
 * 测试mybatis的crud操作
 */
public class MybatisTestcrud {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy() throws Exception {
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() {
        //5.执行查询所有方法
//        List<User> users = userDao.findAll();
//        for (User user : users) {
//            System.out.println(user);
//        }
        List<User> users = userDao.findAll();
        for(User user : users) {
            System.out.println("-------每个用户的内容---------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }

    }


    /**
     * 测试查询id
     */
    @Test
    public void testFindbyid() {
        User user = userDao.findById(41);
        System.out.println(user);

    }

    /**
     * 测试保存操作
     */
    @Test
    public void save(){
        User user = new User();
        user.setId(50);
        user.setAddress("山东青岛");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setUsername("冷凯");
        userDao.saveUser(user);
        System.out.println("操作之后"+user);
    }


    /**
     * 测试更新操作
     */
    @Test
    public void update(){
        User user=userDao.findById(49);
        user.setAddress("湖北武汉");
        int ies = userDao.update(user);

    }


    /**
     * 测试删除操作
     */
    @Test
    public void delete(){
        int res = userDao.delete(41);
        System.out.println(res);
    }



    /**
     * 测试模糊查询操作
     */
    @Test
    public void findbyname(){
        List<User> user = userDao.findByName("%凯");
        System.out.println(user);
    }


    /**
     * 测试查询总记录条数
     */
    @Test
    public void findtol(){
        int count = userDao.findtol();
        System.out.println(count);
    }


    @Test
    public void savetest(){
        User user =new User();
        user.setUsername("太勇");
        int res = userDao.saveUser(user);
        System.out.println(res);
        System.out.println(user.getId());
    }


    /**
     * 测试使用findbyuser
     */
    @Test
    public void findbyuser(){
        User user = new User();
        user.setSex("男");
        user.setUsername("%王");
        List<User> byUser = userDao.findByUser(user);
        System.out.println(byUser);
    }

    /**
     * 测试使用findbyids
     */
    @Test
    public void findbyids(){
        Queryvo vo = new Queryvo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(41);
        ids.add(42);
        ids.add(43);
        ids.add(46);
        ids.add(57);
        vo.setIds(ids);
        List<User> byIds = userDao.findByIds(vo);
        for (User user:byIds) {
            System.out.println(user);
            
        }

    }

}

