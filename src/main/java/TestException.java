/**
 * Created by xiaoyue26 on 17/8/29.
 */
public class TestException {
    public static String fun1() throws Exception {
        String line = "";
        try {
            line = "line from fun1";
            throw new IllegalArgumentException("force throw");
        } catch (Exception e) {
            System.out.println("throw here");
            throw e;
        } finally {
            return line;
        }

    }

    public static void main(String[] args) {
        try {
            System.out.println(fun1());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
