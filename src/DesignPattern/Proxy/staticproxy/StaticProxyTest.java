package DesignPattern.Proxy.staticproxy;

import org.junit.Test;

/**
 * 静态代理模式
 * 特点：代理类和被代理类在编译期间，就确定下来了。
 * 缺点：每增加一个代理类都需要多写一段代码
 *
 * @author ChenZT
 */
public class StaticProxyTest {
    @Test
    public void test() {
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(new NikeClothFactory());
        proxyClothFactory.produceCloth();
    }
}

//接口:服装厂工作
interface ClothFactory {
    void produceCloth();
}


//代理类:代理服装厂
class ProxyClothFactory implements ClothFactory {
    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");
    }
}

//品牌工厂（被代理类）
class NikeClothFactory implements ClothFactory {
    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}
