package practice.chapter7;

import java.util.concurrent.BlockingQueue;

/**
 * Created by xiaoyue26 on 17/10/17.
 * 正确示例.
 * 中断策略之:
 * 能中断但不能取消的任务.
 *
 */
public class TestCancel3 {
    private static class Task {
        // something

    }
    /*
    * 逻辑:
    *  尝试阻塞操作 queue.take()
     * 1. 如果无打断,检查一下以前是否被中断过,有则恢复中断状态,然后返回;
     * 2. 如果有打断,记录一下中断状态,不取消动作,接着尝试take.
      *
      * 表现:
      * 对外一定返回结果,不抛异常.
      * 如果被中断,则保持中断,直到外界清除中断标志.
    */
    public Task getNextTask(BlockingQueue<Task> queue) {
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    return queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    interrupted = true;
                }
            }
        } finally {
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }

    }
}
