package DesignPattern.Proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * @author ChenZT
 */

interface Human {
    String getBelief();

    void eat(String food);
}

// 被代理类
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃：" + food);
    }
}


/*
 * 想要实现动态代理，需要解决的问题？
 * 一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
 * 二：如何通过代理类的对象调用被代理类的同名方法
 * */
class ProxyFactory {
    // 解决问题一
    // 输入参数：obj 被代理类
    // 返回值：代理类对象
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object obj;

    public void bind(Object obj) {
        this.obj = obj;
    }

    /**
     * 调用代理类的同名方法
     *
     * @param proxy  代理类对象
     * @param method 接口中的方法
     * @param args   调用方法的参数
     * @return 调用方法的返回值
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj, args);
    }
}


public class DynamicProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human instance = (Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(instance.getBelief());
        instance.eat("海底捞");

        System.out.println("*******************************************");
        
    }
}
