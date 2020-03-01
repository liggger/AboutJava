package com.liggger.cacheredis;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class MyKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object o, Method method, Object... objects) {
        return method.getName();
    }
}
