package map;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map.*;

/**
 * Created by zhouxu on 2017/11/27 20:31.
 */
public class ConcurrentMapDemo {

    private static Logger log = Logger.getLogger(ConcurrentMapDemo.class);

    @Test
    public void test() {


        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<Object, Object>();

        concurrentHashMap.put("name", "tom");

        log.info("concurrentHashMap>>>>>   " + concurrentHashMap.toString());

//        putIfAbsent: 与原有put方法不同的是,putIfAbsent方法中如果插入的key相同,则不替换原有的value值
        concurrentHashMap.putIfAbsent("name", "lucy");
        log.info("concurrentHashMap>>>>>   " + concurrentHashMap.toString());

//        remove: 与原有remove方法不同的是,新remove方法中增加了对value的判断,如果要删除的key--value不能与Map中原有的key--value对应上,
//        则不会删除该元素
        concurrentHashMap.remove("name", "lucy");
        log.info("concurrentHashMap>>>>>   " + concurrentHashMap.toString());

//
//
// replace(K,V,V): 增加了对value值的判断,如果key--oldValue能与Map中原有的key--value对应上,才进行替换操作
        concurrentHashMap.replace("name", "lucy", "newLucy");
        log.info("concurrentHashMap>>>>>   " + concurrentHashMap.toString());

//        replace(K,V): 与上面的replace不同的是,此replace不会对Map中原有的key--value进行比较,如果key存在则直接替换
        concurrentHashMap.replace("name", "lucy");
        log.info("concurrentHashMap>>>>>   " + concurrentHashMap.toString());

    }


    static Map<Long, String> conMap = new ConcurrentHashMap<Long, String>();

    public static void main(String[] args) throws InterruptedException {

        for (long i = 0; i < 5; i++) {
            conMap.put(i, i + "");
        }

        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (Iterator<Entry<Long, String>> iterator = conMap.entrySet().iterator(); iterator.hasNext();) {
                    Map.Entry<Long, String> entry = iterator.next();
                    log.info(entry.getKey() + " - " + entry.getValue());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                conMap.put(100l, "100");
                log.info("ADD:" + 100);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });


        thread.start();
        thread2.start();

        Thread.sleep(3000);
        log.info("--------");
        for (Map.Entry<Long, String> entry : conMap.entrySet()) {
            log.info(entry.getKey() + " " + entry.getValue());
        }

    }

}
