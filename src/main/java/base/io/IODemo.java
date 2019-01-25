package base.io;

import java.io.*;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2018/11/19
 * Description:
 * Modified:
 */
public class IODemo {

    public static void listAllFiles(File dir) {
        if (dir == null || !dir.exists()) {
            return;
        }
        if (dir.isFile()) {
            System.out.println(dir.getName());
            return;
        }
        for (File file : dir.listFiles()) {
            listAllFiles(file);
        }
    }

    public static void copyFile(String src, String dist) throws IOException {
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dist);

        byte[] buffer = new byte[20 * 1024];
        int cnt;

        // read() 最多读取 buffer.length 个字节
        // 返回的是实际读取的个数
        // 返回 -1 的时候表示读到 eof，即文件尾
        while ((cnt = in.read(buffer, 0, buffer.length)) != -1) {
            out.write(buffer, 0, cnt);
        }

        in.close();
        out.close();
    }

    public static void test_1(String filePath) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
    }

    public static void test_2() throws UnsupportedEncodingException {
        String string = "中文";
        byte[] bytes = string.getBytes("utf-16be");
        String string1 = new String(bytes, "utf-16be");
        System.out.println(string1);

    }

    public static void readFileContent(String filePath) throws IOException {

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        // 装饰者模式使得 BufferedReader 组合了一个 Reader 对象
        // 在调用 BufferedReader 的 close() 方法时会去调用 Reader 的 close() 方法
        // 因此只要一个 close() 调用即可
        bufferedReader.close();
    }

    public static void main(String[] args) throws IOException {
//        IODemo.listAllFiles(new File("./doc"));
//        IODemo.copyFile("./doc/todo.txt", "./doc/to");
//        test_2();
        readFileContent("./doc/todo.txt");
    }
}
