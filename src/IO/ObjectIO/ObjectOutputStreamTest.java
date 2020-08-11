package IO.ObjectIO;

import org.junit.Test;

import java.io.*;

/**
 * @author ChenZT
 */
public class ObjectOutputStreamTest {
    @Test
    public void test() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:\\Code\\Java\\JavaSE\\src\\IO\\objectIO\\employee.dat"));
        Employee harry = new Employee(1, "harry", 23, 5000);
        Employee barry = new Employee(2, "barry", 35, 7000);
        out.writeObject(harry);
        out.writeObject(barry);
        out.close();
    }

    @Test
    public void test2() throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\Code\\Java\\JavaSE\\src\\IO\\objectIO\\employee.dat"));
        Employee e1 = (Employee) in.readObject();
        Employee e2 = (Employee) in.readObject();
        System.out.println(e1.toString());
        System.out.println(e2.toString());

    }
}
