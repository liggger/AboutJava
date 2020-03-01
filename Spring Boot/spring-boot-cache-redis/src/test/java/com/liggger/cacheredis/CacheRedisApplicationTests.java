package com.liggger.cacheredis;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class CacheRedisApplicationTests {

    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        User u1 = userService.getUserById(1, "aa");
        User u2 = userService.getUserById(1, "bb");
        System.out.println(u1);
        System.out.println(u2);
    }

}
