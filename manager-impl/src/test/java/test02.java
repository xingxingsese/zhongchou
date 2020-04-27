import com.lsc.constant.AppEnum;
import org.junit.Test;

/**
 * @author lishuchao
 * @date 2020-04-20 20:41
 */
public class test02 {

    @Test
    public void test002(){
        String key = AppEnum.LOGIN_USER_SESSION_KEY.getKey("loginUser");
        String desc = AppEnum.LOGIN_USER_SESSION_KEY.getDesc();
        System.out.println(desc);
        System.out.println(key);
        String desc1 = AppEnum.LOGIN_USER_SESSION_KEY.getDesc();
        System.out.println(desc1);

    }
}
