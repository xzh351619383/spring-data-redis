package cn.itcast.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * set类型操作  key-value(set集合)  ['',''] 无序 不重复
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class SetTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValue() throws Exception {
        redisTemplate.boundSetOps("setname15").add("曹操");
        redisTemplate.boundSetOps("setname15").add("刘备");
        redisTemplate.boundSetOps("setname15").add("孙权");
        redisTemplate.boundSetOps("setname15").add("孙权");
    }

    @Test
    public void getValue() throws Exception {
        Set set = redisTemplate.boundSetOps("setname15").members();
        System.out.println(set);
    }

    @Test
    public void remove() throws Exception {
        redisTemplate.boundSetOps("setname15").remove("曹操");
    }

    @Test
    public void delete() throws Exception {
        redisTemplate.delete("setname15");
    }
}
