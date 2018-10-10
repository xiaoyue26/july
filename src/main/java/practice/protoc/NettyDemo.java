package practice.protoc;

/**
 * @author xiaoyue26
 */
public class NettyDemo {
    public void test() {
        System.out.println(AddressBookProtos.AddressBook.getDefaultInstance());
    }

    public static void main(String[] args) {
        NettyDemo obj = new NettyDemo();
        obj.test();
        System.out.println("there");
    }
}
