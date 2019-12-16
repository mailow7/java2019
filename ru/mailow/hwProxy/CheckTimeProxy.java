package ru.mailow.hwProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.ClassLoader.getSystemClassLoader;

public class CheckTimeProxy implements InvocationHandler {
    private final Map<List<Object>, Object> cache = new HashMap<>();
    private final Object delegate;

    public CheckTimeProxy(Object delegate) {
        this.delegate = delegate;
    }

    public static <T> T Checktime(T delegate){
        return (T) Proxy.newProxyInstance(
                getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new CheckTimeProxy(delegate)
        );

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long l = System.currentTimeMillis();


        Object result = method.invoke(delegate, args);


        System.out.println( method.getName() + " " + (System.currentTimeMillis() -l) );
        return result;
    }
}
