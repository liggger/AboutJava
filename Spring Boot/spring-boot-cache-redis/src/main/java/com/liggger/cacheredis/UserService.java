package com.liggger.cacheredis;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Cacheable(cacheNames = "c1", keyGenerator = "myKeyGenerator")
    public User getUserById(Integer id) {
        System.out.println("getUserById>>>" + id);
        User user = new User();
        user.setId(id);
        return user;
    }

    @CacheEvict(cacheNames = "c1")
    public void deleteUserById(Integer id) {
        System.out.println("deleteUserById>>>" + id);
    }
}
