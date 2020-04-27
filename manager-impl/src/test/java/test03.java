import org.junit.Test;

/**
 * @author lishuchao
 * @date 2020-04-21 20:18
 */
public class test03 {
    @Test
    public void test01() {
        String result = "";
        String enetityComm = "MCTALERT_123456789_MERCHANTACCOUNT__321";
        String[] enetityComms = enetityComm.split("_", Integer.MAX_VALUE);
        if (enetityComms.length == 5) {

            if (enetityComms[2].contains("MERCHANT")) {

                // 商户门店\商户店铺
                if ("MERCHANTSTOREACCOUNT".equals(enetityComms[2]) || "MERCHANTSHOPACCOUNT".equals(enetityComms[2])) {
                    result = enetityComms[1] + "_" + enetityComms[3];

                }// 商户终端
                if ("MERCHANTTERMINALACCOUNT".equals(enetityComms[2])) {
                    result = enetityComms[1] + "_" + enetityComms[4];

                } // 商户门店终端
                if ("MERCHANTACCOUNT".equals(enetityComms[2])) {
                    result = enetityComms[1] + "_" + enetityComms[3] + "_" + enetityComms[4];
                }
                if (result.contains("__")) {
                    result = result.replace("__", "_");
                }
                if (result.endsWith("_") || result.startsWith("_")) {
                    result = result.substring(0, result.length() - 1);
                }
                System.out.println("拼接后:" + result);

            }
        }
    }
}
