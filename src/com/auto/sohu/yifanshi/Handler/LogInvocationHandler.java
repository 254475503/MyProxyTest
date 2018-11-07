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
* ����proxy������ʹ�ã���һ���ô��ǿ��Եõ������������֡��ڶ�����������˵�������������������������demo�С�sing��һ���ӿ��е�
* ������person��singһ�μ�100��Ǯ������Ҫproxy.sing().sing().sing()������Ǯ��������proxy.sing() proxy.sing() proxy.sing()
* ����û����ķ�ʽ���ʼ�ҵ�sing����ֵ��null����ô���ɵĴ������ͬ������������ֵҲ����null�����Ļ��������null��û�������κη�����
* ����������ʵ�ֲ���proxy.sing().sing()�ġ�Ȼ����롣˭�ܵ���sing��person��Sing�ӿڱ���Ȼ���������Ž�sing����person�����invoke����
* ����proxy��ͬ���������ص���person������proxyֻ��ʵ����sing�ӿڣ������׳��޷���proxyת��Ϊperson���쳣��
* ���sing����sing��invoke����proxy��ͬ����������sing��proxyʵ����sing�ӿڣ����Բ����׳��쳣������Ҳ�ܹ������ٴε���sing������
* ������������
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
