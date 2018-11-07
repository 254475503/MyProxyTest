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

/*
* 关于proxy参数的使用，第一个用处是可以得到代理对象的名字。第二个就是我们说的连续代理啦。比如在我这个demo中。sing是一个接口中的
* 方法，person中sing一次加100块钱。我想要proxy.sing().sing().sing()连续加钱，而不是proxy.sing() proxy.sing() proxy.sing()
* 这种没排面的方式。最开始我的sing返回值是null，那么生成的代理类的同名函数，返回值也会是null（配合幕布看），null是没法调用任何方法的
* 所以这样是实现不了proxy.sing().sing()的。然后就想。谁能调用sing？person和Sing接口本身。然后我又试着将sing返回person，这回invoke返回
* 的是proxy，同名函数返回的是person，但是proxy只是实现了sing接口，所以抛出无法将proxy转换为person的异常。
* 最后sing返回sing。invoke返回proxy，同名函数返回sing。proxy实现了sing接口，所以不会抛出异常，而且也能够调用再次调用sing方法。
* 这样就完美啦
* */

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
