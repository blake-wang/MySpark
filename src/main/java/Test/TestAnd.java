package Test;

/**
 * Created by bigdata on 17-11-11.
 */
public class TestAnd {
    public static void main(String[] args) {
        String imei = "aaa";
        String ip = "";
        String devType = "";
        String sysVersion = "";


//        test1(imei, ip, devType, sysVersion);

        if (!imei.equals("") || !imei.equals("00000000-0000-0000-0000-000000000000")) {
            System.out.println(imei);
        }

    }

    private static void test1(String imei, String ip, String devType, String sysVersion) {
        if (!((imei.equals("") || imei.equals("00000000-0000-0000-0000-000000000000")) && ip.equals("") && devType.equals("") && sysVersion.equals(""))) {
            System.out.println("imei : " + imei);
            System.out.println("ip : " + ip);
            System.out.println("devType : " + devType);
            System.out.println("sysVersion : " + sysVersion);

        }
    }
}
