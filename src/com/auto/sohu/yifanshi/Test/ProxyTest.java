package com.auto.sohu.yifanshi.Test;

import com.auto.sohu.yifanshi.Handler.LogInvocationHandler;
import com.auto.sohu.yifanshi.targetClasses.Person;
import com.auto.sohu.yifanshi.targetClasses.Sing;
import com.auto.sohu.yifanshi.targetClasses.Teach;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Class clazz = (new Person()).getClass();
        Class<?> interFaces[] = clazz.getInterfaces();
        Person person = new Person();
        LogInvocationHandler invocationHandler = new LogInvocationHandler(person);
        ClassLoader classLoader = clazz.getClassLoader();
        Teach personProxy = (Teach) Proxy.newProxyInstance(classLoader,interFaces,invocationHandler);
        personProxy.teaching();
        Sing personProxy1 = (Sing) Proxy.newProxyInstance(classLoader,interFaces,invocationHandler);
        personProxy1.Sing().Sing().Sing().Sing().Sing();
        System.out.println(person.getMoney());
    }
}
