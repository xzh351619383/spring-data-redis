package cn.itcast.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 值操作  key-value(字符串)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class ValueTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValue() throws Exception {

        redisTemplate.boundValueOps("valuename15").set("张三丰");

    }

    @Test
    public void getvalue() throws Exception {
        String name = (String) redisTemplate.boundValueOps("valuename15").get();
        System.out.println(name);
    }

    @Test
    public void delete() throws Exception {
        redisTemplate.delete("seckillGoods");
    }
}
