package practice.chapter7;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by xiaoyue26 on 17/10/18.
 *
 * 用毒丸来结束整场作业.
 * 优点: 形象好理解
 * 缺陷:
 * 1. 仅当生产者消费者数量已知的情况使用;
 * 2. 无界队列场景下,使用.
 *
 */
public class TestPoisonPill {

    public static class IndexingService {
        private static final File POISON = new File("");
        private final IndexedThread consumer = new IndexedThread();
        private final CrawlerThread producer = new CrawlerThread();
        private static final BlockingQueue<File> queue = new LinkedBlockingQueue<>(100);
        ;
        private final FileFilter fileFilter;
        private final File root;

        public IndexingService(FileFilter fileFilter, File root) {
            this.fileFilter = fileFilter;
            this.root = root;
        }

        public void start() {
            producer.start();
            consumer.start();
        }

        public void stop() {
            producer.interrupt();
        }

        public void awaitTermination() throws InterruptedException {
            consumer.join();
        }

        private static class IndexedThread extends Thread {
            public void run() {
                try {
                    while (true) {
                        File file = queue.take();
                        if(file==POISON){
                            break;// 遇到毒丸就退出.
                        }
                        else{
                            //indexFile(file)
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        private class CrawlerThread extends Thread {
            public void run() {
                try {
                    // crawl(root)
                } catch (Exception e) {

                } finally {
                    while (true) {
                        try {
                            queue.put(POISON);// 放入毒丸给消费者.
                            break;
                        } catch (InterruptedException e) {
                            e.printStackTrace();// 重试
                        }
                    }
                }
            }
        }
    }
}
