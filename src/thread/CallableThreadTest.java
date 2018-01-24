package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by zhouxu on 2017/11/15 17:15.
 */
public class CallableThreadTest implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {

        int i;
        for (i = 0; i < 100; i++) {

            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
//        100
        return i;
    }


    public static void main(String[] args) {


//        第一种创建线程的方式
        new Thread() {

            @Override
            public void run() {
                super.run();

                System.out.println("创建线程1>>>>>" + Thread.currentThread().getName());
            }
        }.start();

//        第二种创建线程的方式
        new Thread(new Runnable() {

            @Override
            public void run() {

                System.out.println("创建线程2>>>>>" + Thread.currentThread().getName());
            }
        }).start();


//        第三种创建线程的方式
        CallableThreadTest callableThreadTest = new CallableThreadTest();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callableThreadTest);

        for (int i = 0; i < 100; i++) {

            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
            if (i == 20) {

                new Thread(futureTask, "有返回值的线程").start();
                System.out.println("i == 20,当前线程>>>>>>" + Thread.currentThread().getName());
            }
        }

        try {
//            100
            System.out.println("子线程的返回值>>>>>" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
