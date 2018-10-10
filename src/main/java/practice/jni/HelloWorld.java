package practice.jni;

/**
 * @author xiaoyue26
 */
public class HelloWorld {
    private native void print();

    public static void main(String[] args) {
        new HelloWorld().print();
    }

    static {
        //System.loadLibrary("HelloWorld");
        // System.loadLibrary("HelloWorld");
        System.load("/opt/ld_path/libHelloWorld.so");

    }
}
