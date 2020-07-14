package IO.NIOTest;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author ChenZT
 */
public class PathTest {
    @Test
    public void test() throws IOException {

        String str = "D:\\Code\\Java\\JavaSE\\src\\IO\\PathsTest\\hello.txt";
        Path path = Paths.get(str);
        System.out.println(path);
        // Path getName(int index) path.getNameCount()
        // int getNameCount()
        // The element that is closest to the root in the directory hierarchy has index 0.
        // The element that is farthest from the root has index count-1.
        System.out.println(path.getName(0));
        System.out.println(path.getName(1));
        System.out.println(path.getNameCount());
        System.out.println(path.getName(path.getNameCount() - 1));
        System.out.println(Files.size(path));
    }

    @Test
    public void test2() {
        Path path = Paths.get(".");
        System.out.println(path.toString());
        Path p2 = Paths.get("D", "ReviewIO", "URL"); // D\ReviewIO\URL
        System.out.println(p2.toString());
    }

}
