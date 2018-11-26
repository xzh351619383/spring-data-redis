package cn.itcast.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * List类型操作  key-value(list格式) [] 有序 可重复
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class ListTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValue() throws Exception {
        redisTemplate.boundListOps("listname15").rightPush("唐僧");
        redisTemplate.boundListOps("listname15").rightPush("悟空");
        redisTemplate.boundListOps("listname15").rightPush("八戒");
        redisTemplate.boundListOps("listname15").rightPush("沙僧");
        redisTemplate.boundListOps("listname15").rightPush("沙僧");
    }

    @Test
    public void getValue() throws Exception {
        List list = redisTemplate.boundListOps("listname15").range(0, 10);
        System.out.println(list);
    }

    @Test
    public void setValue2() throws Exception {
        redisTemplate.boundListOps("listname16").leftPush("宋江");
        redisTemplate.boundListOps("listname16").leftPush("武松");
        redisTemplate.boundListOps("listname16").leftPush("林冲");
        redisTemplate.boundListOps("listname16").leftPush("林冲");
        redisTemplate.boundListOps("listname16").leftPush("李逵");
    }

    @Test
    public void getValue2() throws Exception {
        List list = redisTemplate.boundListOps("listname16").range(0, 10);
        System.out.println(list);
    }

    @Test
    public void getValueByIndex() throws Exception {
        String name = (String) redisTemplate.boundListOps("listname16").index(3);
        System.out.println(name);
    }

    @Test
    public void remove() throws Exception {
        redisTemplate.boundListOps("listname16").remove(1,"武松");
    }

    @Test
    public void delete() throws Exception {
        redisTemplate.delete("listname16");
    }
}
