package com.liggger.cacheredis;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Cacheable(cacheNames = "c1", key = "#id")
    public User getUserById(Integer id, String name) {
        System.out.println("getUserById>>>" + id);
        User user = new User();
        user.setId(id);
        return user;
    }
}
