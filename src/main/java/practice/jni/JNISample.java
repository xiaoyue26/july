package practice.jni;

/**
 * @author xiaoyue26
 */
public class JNISample {
    public native void callMe(); // native

    public static void main(String[] atgs) {
        new JNISample().callMe(); // It will print "I am called"
    }
}