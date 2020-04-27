import com.lsc.bean.TAdmin;
import com.lsc.constant.AppEnum;
import com.lsc.mapper.TAdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lishuchao
 * @date 2020-04-19 23:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
//值是String数组，可以写多个xml配置文件
@ContextConfiguration(locations = {"classpath:spring-beans.xml","classpath:spring-mybatis.xml"})
public class test01 {

    @Autowired
    TAdminMapper tAdminMapper;

    @Test
    public void test001(){
        TAdmin admin = tAdminMapper.selectByPrimaryKey(1);
        System.out.println(admin);
    }


}
