package IO.CharacterStream;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ChenZT
 * 1.File类的实例化
 * 2.FileReader流的实例化
 * 3.读入的操作
 * 4.资源的关闭
 */
public class ReaderTest {
    public static String path = "D:\\Code\\Java\\JavaSE\\src\\IO\\CharacterStream";

    public static void main(String[] args) {

    }


    @Test
    public void FileReaderTest() {
        File file = new File(path + "\\Hello.txt");
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] c = new char[5];
            int len;
            // reader.read() // 一个字符一个字符地读取
            while ((len = reader.read(c)) != -1) { // 一组一组的读取，大小自己设定
                System.out.print(new String(c, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test() throws IOException {
        File file = new File(path + "\\Hello.txt");
        FileReader reader = new FileReader(file);
        char[] c = new char[1024];
        int len;
        while ((len = reader.read(c)) != -1) { // 一组一组的读取，大小自己设定
            System.out.print(new String(c, 0, len));
        }
        reader.close();
    }

    /*
    从内存中写出数据到硬盘的文件里。

    说明：
    1. 输出操作，对应的File可以不存在的。并不会报异常
    2.
         File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
         File对应的硬盘中的文件如果存在：
                如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原有文件的覆盖
                如果流使用的构造器是：FileWriter(file,true):不会对原有文件覆盖，而是在原有文件基础上追加内容
    */
    @Test
    public void FileWriterTest() throws IOException {
        /**
         * 1.提供File类的对象，指明写出到的文件
         * 2.提供FileWriter的对象，用于数据的写出
         * 3.写出的操作
         * 4.流资源的关闭
         */
        File file = new File(path + "\\Hello.txt");
        System.out.println(file);
        FileWriter fileWriter = new FileWriter(file, true);

        fileWriter.write("I have a dream!\n");
        fileWriter.write("you need to have a dream!");
        fileWriter.close();
    }
}
