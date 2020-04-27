import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lsc.api.AdminService;
import com.lsc.bean.TAdmin;
import com.lsc.mapper.TAdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author lishuchao
 * @date 2020-04-22 22:49
 */
@ContextConfiguration(locations = {"classpath:spring-beans.xml","classpath:spring-mybatis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminServiceTest {

    @Autowired
    AdminService adminService;

    @Autowired
    TAdminMapper adminMapper;

    @Test
    public void pageTest(){
        PageHelper.startPage(1,3);
        List<TAdmin> tAdmins = adminService.listAllAdmin();
        PageInfo<TAdmin> pageInfo = new PageInfo<>(tAdmins);
        System.out.println(pageInfo);
        System.out.println(pageInfo.getList());

    }
}
