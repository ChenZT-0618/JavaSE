package IO.File;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类的使用
 * <p>
 * 1. File类的一个对象，代表一个文件或一个文件目录(俗称：文件夹)
 * 2. File类声明在java.io包下
 * 3. File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，
 * 并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成。
 * 4. 后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的"终点".
 *
 * @author ChenZT
 */
public class FileTest {
    public String path = "D:\\Code\\Java\\JavaSE\\src\\IO\\File";

    /*
    1.如何创建File类的实例
        File(String filePath)
        File(String parentPath,String childPath)
        File(File parentFile,String childPath)

    2.
    相对路径：相较于某个路径下，指明的路径。
    绝对路径：包含盘符在内的文件或文件目录的路径

    3.路径分隔符
     windows:\\
     unix:/
     File.separator
     */
    // 分隔符常量 解决不同操作系统分隔符表示不同的问题
    @Test
    public void test() {
        // 相对路径 : D:\Code\Java\JavaSE\hello.txt
        File file = new File("hello.txt");
        // 绝对路径
        File file2 = new File("D:\\Code\\Java\\JavaSE\\src\\IO\\File\\hello2.txt");

        System.out.println(file.getAbsolutePath());
        System.out.println(file2);

        File file3 = new File("D:\\Code\\Java\\JavaSE\\src\\IO\\File", "hello3.txt");
        System.out.println(file3);

        File f = new File(this.getClass().getResource("/").getPath());
        System.out.println(f);
    }


    /*
    public String getAbsolutePath()：获取绝对路径
    public String getPath() ：获取路径
    public String getName() ：获取名称
    public String getParent()：获取上层文件目录路径。若无，返回null
    public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
    public long lastModified() ：获取最后一次的修改时间，毫秒值


     */
    @Test
    public void test2() {
        File file1 = new File("D:\\Code\\Java\\JavaSE\\src\\IO\\File\\hello.txt");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));
    }

    /*
    如下的两个方法适用于文件目录：
    public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
    public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
    public boolean isDirectory()：判断是否是文件目录
    public boolean isFile() ：判断是否是文件

    其他判断方法
    public boolean exists() ：判断是否存在
    public boolean canRead() ：判断是否可读
    public boolean canWrite() ：判断是否可写
    public boolean isHidden() ：判断是否隐藏
    */
    @Test
    public void test3() {
        File file1 = new File("D:\\Code\\Java\\JavaSE\\src\\IO");
        String path = "D:\\Code\\Java\\JavaSE\\src";
        printFile(path, false);
    }

    public void printFile(String path, boolean isChild) {
        File file = new File(path);
        File[] files = file.listFiles();
        if (files == null) {
            return;
        }
        for (File f : files) {
            if (f.isFile()) {
                if (isChild) {
                    System.out.println("\t" + f.getName());
                } else {
                    System.out.println(f.getName());
                }
                // System.out.println(f.getName());
            } else if (f.isDirectory()) {
                if (isChild) {
                    System.out.println("\t" + f.getName());
                } else {
                    System.out.println(f.getName());
                }
                printFile(f.getAbsolutePath(), true);

            }
        }
    }

    /*
    创建硬盘中对应的文件或文件目录
    public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
    public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
    public boolean mkdirs() ：创建文件目录。如果此文件目录存在，就不创建了。如果上层文件目录不存在，一并创建

    删除磁盘中的文件或文件目录
    public boolean delete()：删除文件或者文件夹
    删除注意事项：Java中的删除不走回收站。
    */
    @Test
    public void test4() {
        File file;

        try {
            file = new File(path + File.separator + "hello2.txt");
            if (!file.exists()) {
                System.out.println(file.createNewFile() + "--创建成功");
            } else {
                System.out.println(file.delete() + "--删除成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test5() {
        // 输出指定后缀名的文件
        File file = new File("D:\\Code\\Java\\JavaSE\\src\\IO");
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.getName().endsWith(".md")) {
                System.out.println(f.getName());
            }
        }

    }

    // 拓展2：删除指定的目录
    public void deleteDirectory(File file) {
        // 如果file是文件，直接delete
        // 如果file是目录，先把它的下一级干掉，然后删除自己
        if (file.isDirectory()) {
            File[] all = file.listFiles();
            // 循环删除的是file的下一级
            for (File f : all) {// f代表file的每一个下级
                deleteDirectory(f);
            }
        }
        // 删除自己
        file.delete();
    }
}
