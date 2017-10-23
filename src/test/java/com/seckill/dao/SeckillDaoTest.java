package com.seckill.dao;

import com.seckill.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by asus on 2017/10/18.
 *
 * 配置spring和junit整合，这样junit在启动时就会加载spring容器
 */

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    //注入Dao实现类依赖
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void testReduceNumber() throws Exception {
        long seckillId = 1000L;
        Date date = new Date();
        int updateCount = seckillDao.reduceNumber(seckillId,date);
        System.out.println(updateCount);

    }

    @Test
    public void testQueryById() throws Exception {
        long seckillId=1000;
        Seckill seckill = seckillDao.queryById(seckillId);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void testQueryAll() throws Exception {
        /*
         * Caused by: org.apache.ibatis.binding.BindingException:
         * Parameter 'offset' not found. Available parameters are [1, 0, param1, param2]
        */
        //List<Seckill> queryAll(int offset, int limit)
        //java没有保存形参的记录:queryAll(int offset, int limit) ====> queryAll(arg0, arg1)

        List<Seckill> seckills = seckillDao.queryAll(0,100);
        for (Seckill seckill : seckills) {
            System.out.println(seckill);
        }
    }

}









