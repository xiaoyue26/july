package practice.chapter7;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by xiaoyue26 on 17/10/18.
 * 处理难以直接中断的操作.
 * 简单方法: 用线程封装.
 *
 */
public class TestInterrupt1 {
    public class ReaderThread extends Thread {
        private static final int BUFSZ = 1024;
        private final Socket socket;
        private final InputStream in;

        public ReaderThread(Socket socket) throws IOException {
            this.socket = socket;
            in = socket.getInputStream();
        }

        public void interrupt() {
            try {
                socket.close(); // 自定义的interrupt, 关闭底层套接字
            } catch (IOException e) {
                e.printStackTrace();// do nothing
            } finally {
                super.interrupt();// 调用Thread的interrupt
            }
        }

        public void run() {
            try {
                byte[] buf = new byte[BUFSZ];
                while (true) {
                    int count = in.read(buf);
                    if (count < 0) {
                        break;
                    } else if (count > 0) {
                        // process buffer (buf,count)
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
