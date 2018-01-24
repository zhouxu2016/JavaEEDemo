package executor;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zhouxu
 * Created by zhouxu on 2017/11/16 14:33.
 */
public class ExecutorDemo {

    private ExecutorService executorService1;
    private ExecutorService executorService2;
    private ScheduledExecutorService executorService3;
    private static Logger log = Logger.getLogger(ExecutorDemo.class);

    @BeforeEach
    private void studyExecutor() {
//        创建线程池的三种方式
//        1.创建SingleThread,创建一个线程的线程池
        executorService1 = Executors.newSingleThreadExecutor();

//        2.创建固定线程数量的线程池
        executorService2 = Executors.newFixedThreadPool(10);

//        3.创建周期性线程池
        executorService3 = Executors.newScheduledThreadPool(10);
    }

    @Test
    public void executeRunnable() {
//       创建固定线程数量的线程池
        executorService2 = Executors.newFixedThreadPool(10);
//        异步执行线程任务
        executorService2.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Asynchronous task");
            }
        });
//        等待所有的线程执行线程任务完毕后,关闭线程
        executorService2.shutdown();
    }

    @Test
    public void submitRunnable() {

        Future<?> future = executorService2.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Asynchronous task");
            }
        });
        try {
//            如果任务执行结束则返回null
            System.out.println("future.get()>>>>>>" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService2.shutdown();
    }

    @Test
    public void submitCallableRunnable() {

        Future<Object> future = executorService2.submit(new Callable<Object>() {
//            使用Callable接口可以返回一个结果
            @Override
            public Object call() throws Exception {

                return "Callable Result";
            }
        });
        try {
//            获取Callable接口中call()方法的返回结果
            System.out.println("future.get()>>>>>>>>  " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService2.shutdown();
    }

    @Test
    public void inVokeAnyRunnable() {

        List<Callable<String>> callableList = new ArrayList<Callable<String>>();

        callableList.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task1";
            }
        });

        callableList.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task2";
            }
        });

        callableList.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task3";
            }
        });

        try {

            String result = executorService2.invokeAny(callableList);
            log.info("result>>>>>>>>>>>>>>  " + result);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService2.shutdown();
    }

    @Test
    public void inVokeAllRunnable() {

        List<Callable<String>> callableList = new ArrayList<Callable<String>>();

        callableList.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task1";
            }
        });

        callableList.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task2";
            }
        });

        callableList.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task3";
            }
        });

        try {

            List<Future<String>> futureList = executorService2.invokeAll(callableList);
            for (Future<String> future : futureList) {

                log.info("future.get()>>>>>>>  " + future.get());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService2.shutdown();
    }

}