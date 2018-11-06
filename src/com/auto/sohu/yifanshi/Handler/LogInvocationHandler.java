package com.auto.sohu.yifanshi.Handler;

import com.auto.sohu.yifanshi.targetClasses.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Handler;

public class LogInvocationHandler implements InvocationHandler {

    private Object target;

    public LogInvocationHandler(Object target)
    {
        this.target = target;
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("Sing"))
        {
            System.out.println("Look MusicBook Before Singing");
            method.invoke(target,args);
            return proxy;
        }
        else {
            System.out.println("Practice Before Teaching");
            return proxy;
        }

    }}
