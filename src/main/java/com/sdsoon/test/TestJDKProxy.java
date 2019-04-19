package com.sdsoon.test;

import com.sdsoon.Boss;
import com.sdsoon.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created By Chr on 2019/4/18/0018.
 */
public class TestJDKProxy {

    public static void main(String[] args) {
        Boss xdd = new Boss();
        //xdd.eat();
		/*
			1:类加载器对象
				xdd.getClass().getClassLoader();
				你用哪个类加载器加载目标类型的.class
				就用同一个类加载器加载代理类的.class

			2:要实现的接口类型
				xdd.getClass().getInterfaces();
				目标类型实现哪些接口 代理类型也实现那些接口

			3:InvocationHandler => 调用控制器
				一个非核心业务的代码载体
		*/
        Person ms = (Person) Proxy.newProxyInstance(
                xdd.getClass().getClassLoader(),
                xdd.getClass().getInterfaces(),
                new InvocationHandler(){
                    /*
                        a> 代理类的对象 ->
                        b> 要代理的方法 -> Method
                        c> 调用方法的参数
                    */
                    @Override
                    public Object invoke(Object obj, Method m, Object[] args)
                            throws Throwable {
                        //String name = m.getName();
                        System.out.println("== 非核心前置操作 ==");
                        Object returnValue = m.invoke(xdd,args);
                        System.out.println("== 非核心后置操作 ==");
                        return returnValue;
                    }
                });

        ms.eat();
        ms.sleep();
    }

}
