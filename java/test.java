
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Date;

public class test {
    public static void main(String[] args) throws Exception {

//        String url = ''
        //测试与正式AppSecret，AppKey不同（运行环境不允许私自修改,因工改与各个系统对接）
        /**
         *正式AppSecret，AppKey:   epoint_zhdn
         *
         *测试AppSecret，AppKey:  epoint_zhdn
         */
        String AppSecret = "epoint_zhdn";
        String AppKey = "epoint_zhdn";
        /**
         *   （1）失效时间戳（Unix时间戳） –P1  
         *    将未来的某个时间作为凭证的失效时间点（当前时间+5分钟，
         *    5分钟内有效），并将其转换为Unix时间戳，
         *    示例：把2015-12-31 00:00:00转换成整数：1451491200
         */
        Date date=new Date();
        String P1 = getP1(date);
        /**
         * （2）将P1进行UrlEncode，并转换成Base64编码-P2(待签名字符串) 
         */
        String P2 = Base64.getEncoder().encodeToString(URLEncoder.encode(P1, "UTF-8").getBytes());
        /**
         * （3）使用AppSecret对P2进行HMAC-SHA1签名，得到P3
         */
        SecretKeySpec signingKey = new SecretKeySpec(AppSecret.getBytes("UTF-8"), "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(signingKey);
        byte[] P3 = mac.doFinal(P2.getBytes("UTF-8"));
        String P4= Base64.getEncoder().encodeToString(P3).replace("+", "-").replace("/", "_");
        System.out.println(AppKey + "@" + P4 + "@" + P2);

    }

private static String getP1(Date date) {
    /**
     * 当前时间+5分钟
     */
    Long time = date.getTime() + 5 * 60 * 1000;

    return String.valueOf(time / 1000);
}
}
