package practice;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author xiaoyue26
 */
public class ByteGenerate {
    public void test() throws IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        long len = (long) Math.pow(10, 8);
        for (int i = 0; i < len; i++) {
            bout.write((byte) (Math.random() * 100));
        }
        try (OutputStream outputStream = new FileOutputStream("out_file.bin")) {
            bout.writeTo(outputStream);
        }


    }

    public static void main(String[] args) throws IOException {
        ByteGenerate obj = new ByteGenerate();
        obj.test();
        System.out.println("there");
    }
}
