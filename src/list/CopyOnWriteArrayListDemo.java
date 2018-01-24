package list;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhouxu on 2017/11/17 15:58.
 */
public class CopyOnWriteArrayListDemo {

    private static Logger log = Logger.getLogger(CopyOnWriteArrayListDemo.class);

    /**
     * 读线程
     */
    private static class ReadTask implements Runnable {

        List<String> list;

        public ReadTask(List<String> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (String str : list) {

                log.info("ReadTask>>>>>" + str);
            }
        }
    }

    /**
     * 写线程
     */
    private static class WriteTask implements Runnable {

        private int index;
        private List<String> list;

        public WriteTask(int index, List<String> list) {
            this.index = index;
            this.list = list;
        }

        @Override
        public void run() {

            list.remove(index);
            list.add(index, "write>>" + index);
        }
    }

    private void run() {

        final int NUM = 10;
//        List<String> list = new ArrayList<String>();
        List<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < NUM; i++) {
            list.add("main_" + i);
        }

//        创建指定线程数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(NUM);
        for (int i = 0; i < NUM; i++) {

            executorService.execute(new ReadTask(list));
            executorService.execute(new WriteTask(i, list));
        }

//        等待线程任务执行结束之后,关闭线程
//        executorService.shutdown();
//        立即关闭所有线程(即便是正在执行线程任务的线程,但结果不一定能够成功关闭)
        executorService.shutdownNow();
    }

    public static void main(String[] args) {

//        java.util.ConcurrentModificationException,修改并发异常
        new CopyOnWriteArrayListDemo().run();

    }

}
