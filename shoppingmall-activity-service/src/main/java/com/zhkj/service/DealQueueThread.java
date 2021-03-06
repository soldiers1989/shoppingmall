package com.zhkj.service;

import com.zhkj.vo.activity_vo.UserVo;
import org.apache.naming.factory.ResourceFactory;
import org.redisson.api.RDeque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DealQueueThread {
    public static RedisCacheService redisCacheService;
    public static StringRedisTemplate stringRedisTemplate;

    private static DealQueueThread dealQueueThread;
//    @Autowired
//    BuyGoodService buyGoodService;
//    @Autowired
//    BuyOrdersService buyOrdersService;
//    @Autowired
//    JedisPool jedisPool;

//    private Jedis jedis;

    private RDeque<UserVo> buyqueue;

    public static boolean excute = false;//线程的默认执行标志为未执行,即空闲状态

    public DealQueueThread() {

    }

    public DealQueueThread(RDeque<UserVo> buyqueue) {
        this.buyqueue = buyqueue;
    }

    @PostConstruct
    public void init() {
        dealQueueThread = this;
    }

    public void run() {
        try {
            excute = true;//修改线程的默认执行标志为执行状态
            //开始处理请求队列中的请求,按照队列的FIFO的规则,先处理先放入到队列中的请求
            while (buyqueue != null && buyqueue.size() > 0) {
                UserVo userVo = buyqueue.poll();//取出队列中第一个值 并且删除值
                dealWithQueue(userVo);//处理请求
            }
        } finally {
            excute = false;
        }
    }

    static int residue = 0;

    public void dealWithQueue(UserVo buyreq) {
        try {

            //为了尽量确保数据的一致性,处理之前先从redis中获取当前抢购商品的剩余数量
            residue = redisCacheService.countRedisCache(String.valueOf(buyreq.getHoppingName()));
            if (residue < 1) {//如果没有剩余商品,就直接返回
                //返回商品
                System.out.println("商品已经没有了");
                return;
            }
            //如果有剩余商品,先在redis中将剩余数量减一,再开始下订单
            String startTime = String.valueOf(buyreq.getStartTime());

            int count = Integer.parseInt(String.valueOf(increment()));
            String id = String.valueOf(buyreq.getHoppingName());
            redisCacheService.updateRedis(startTime, id, count);
            stringRedisTemplate.opsForValue().set("count1", String.valueOf(increment()));
            System.out.println("下单成功");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * 用作减去商品
     */
    public static AtomicInteger increment() {
        AtomicInteger count = new AtomicInteger(residue);
        count.getAndDecrement();
        System.out.println(Thread.currentThread().getName() + "数量递减：" + count);
        return count;
    }

}
