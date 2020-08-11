package ObjectOriented.Interface;

/**
 * @author ChenZT
 */
public class InterfaceTest {
    public static void main(String[] args) {
        Plane p1 = new Plane();
        p1.attack();
    }
}

interface Flyable {
    int MAX_SPEED = 7990;

    void fly();

    void stop();
}

interface Attackable {

    void attack();

}

class Plane implements Flyable, Attackable {
    @Override
    public void fly() {
        System.out.println("起飞");
    }

    @Override
    public void stop() {
        System.out.println("降落");
    }

    @Override
    public void attack() {
        System.out.println("攻击");
    }
}
