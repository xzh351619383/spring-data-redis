package cn.itcast.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 *  hash类型操作  key-value({key1:value,key2,value})
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class HashTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValue() throws Exception {
        redisTemplate.boundHashOps("hashname15").put("a","孙尚香");
        redisTemplate.boundHashOps("hashname15").put("b","大乔");
        redisTemplate.boundHashOps("hashname15").put("c","小乔");

    }

    @Test
    public void getValue() throws Exception {
        Set set = redisTemplate.boundHashOps("hashname15").keys();
        System.out.println(set);
        List list = redisTemplate.boundHashOps("hashname15").values();
        System.out.println(list);
    }

    @Test
    public void getValueBykey() throws Exception {
        String name = (String) redisTemplate.boundHashOps("hashname15").get("b");
        System.out.println(name);
    }

    @Test
    public void deletebyKey() throws Exception {
        redisTemplate.boundHashOps("hashname15").delete("a");
    }

    @Test
    public void deleteAll() throws Exception {
        redisTemplate.delete("contentList");
    }
}
