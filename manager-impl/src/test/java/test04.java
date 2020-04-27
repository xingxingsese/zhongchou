import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lishuchao
 * @date 2020-04-24 18:14
 */
public class test04 {
    public void test01(){
        File file = new File("D:\\data\\appLogs");
        File[] files = file.listFiles();
        Arrays.sort(files, Comparator.comparingLong(File::lastModified));
        long count = files.length;
        for(File file1:files){
            if(count>5){
                file1.delete();
                count--;
            }else {
                break;
            }

        }
    }
}
