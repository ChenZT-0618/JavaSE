package IO.ByteStream;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流文件操作
 * <p>
 * 测试FileInputStream和FileOutputStream的使用
 * 结论：
 * 1. 对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
 * 2. 对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)，使用字节流处理
 *
 * @author ChenZT
 */
public class StreamTest {

    public static String path = "D:\\Code\\Java\\JavaSE\\src\\IO\\ByteStream";

    //1. 造文件
    //2.造流
    //3.读数据
    //4.关闭资源
    @Test
    public void test() throws IOException {
        File inputFile = new File(path + "\\视频1.mkv");
        File outputFile = new File(path + "\\.jpg");
        FileInputStream fis = new FileInputStream(inputFile);
        FileOutputStream fos = new FileOutputStream(outputFile);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);

        }
        fis.close();
        fos.close();

    }
}
