package practice.chapter5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by xiaoyue26 on 17/10/15.
 * 复杂示例. 还是看TestBarrier2吧.
 */
public class TestBarrier {// 测试栅栏

    public static class CellularAutomata {
        private final Board mainBoard;
        private final CyclicBarrier barrier;
        private final Worker[] workers;

        public CellularAutomata(Board mainBoard) {
            this.mainBoard = mainBoard;
            int count = Runtime.getRuntime().availableProcessors();
            barrier = new CyclicBarrier(count, () -> mainBoard.commmitNewValues());
            workers = new Worker[count];
        }

        private class Board {
            public void commmitNewValues() {
            }

            public void waitForConvergence() {
            }

            public boolean hasConverged() {
                return false;
            }

            public int getMaxX() {
                return 10;
            }

            public int getMaxY() {
                return 10;
            }

            public void setNewValue(int x, int y, int i) {
            }
        }

        private class Worker implements Runnable {
            private final Board board;

            private Worker(Board board) {
                this.board = board;
            }

            @Override
            public void run() {
                while (!board.hasConverged()) {
                    for (int x = 0; x < board.getMaxX(); x++) {
                        for (int y = 0; y < board.getMaxY(); y++) {
                            board.setNewValue(x, y, computeValue(x, y));
                        }
                    }
                    try {
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }

            private int computeValue(int x, int y) {
                return x + y;
            }
        }

        public void start() {
            for (int i = 0; i < workers.length; i++) {
                new Thread(workers[i]).start();
            }
            mainBoard.waitForConvergence();
        }
    }
}
