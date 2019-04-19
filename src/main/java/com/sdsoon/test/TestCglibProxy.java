package com.sdsoon.test;

import com.sdsoon.Boss;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created By Chr on 2019/4/18/0018.
 */
public class TestCglibProxy {

    public static void main(String[] args) {
        Boss xdd = new Boss();
        //cglib的底层
        Enhancer en = new Enhancer();//增强器
        en.setSuperclass(xdd.getClass());//代理类以哪个类为父类
        en.setCallback(new MethodInterceptor() {
            //obj就是核心代码，args是（代理目标）核心代码的参数
            @Override
            public Object intercept(Object obj, Method m, Object[] args,
                                    MethodProxy mp) throws Throwable {
                System.out.println("== 前置的非核心操作 ==");
                //m.invoke(xdd, args);
                Object returnValue = mp.invokeSuper(obj, args);
                System.out.println("== 后置的非核心操作 ==");
                return returnValue;
            }
        });
        Boss ms = (Boss) en.create();
        ms.eat();
    }

}
