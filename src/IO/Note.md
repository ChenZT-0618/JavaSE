

## IO流

### File类

### 分类

字节流：非文本——图片等，字符流：文本

输入流、输出流

节点流、处理流

| (抽象基类) | 字节流       | 字符流 |
| ---------- | ------------ | ------ |
| 输入流     | InputStream  | Reader |
| 输出流     | OutputStream | Writer |

### IO流体系

|     分类     |      字节输入流      |      字节输出流       |    字符输入流     |     字符输出流     |
| :----------: | :------------------: | :-------------------: | :---------------: | :----------------: |
|   抽象基类   |     InputStream      |     OutputStream      |      Reader       |       Writer       |
| **访问文件** |   FileInputStream    |   FileOutputStream    |    FileReader     |     FileWriter     |
|   访问数组   | ByteArrayInputStream | ByteArrayOutputStream |  CharArrayReader  |  CharArrayWriter   |
|   访问管道   |   PipedInputStream   |   PipedOutputStream   |    PipedReader    |    PipedWriter     |
|  访问字符串  |                      |                       |   StringReader    |    StringWriter    |
|  **缓冲流**  | BufferedInputStream  | BufferedOutputStream  |  BufferedReader   |   BufferedWriter   |
|    转换流    |                      |                       | InputStreamReader | OutputStreamWriter |
|    对象流    |  ObjectInputStream   |  ObjectOutputStream   |                   |                    |
|              |  FilterInputStream   |  FilterOutputStream   |   FilterReader    |    FilterWriter    |
|    打印流    |                      |      PrintStream      |                   |    PrintWriter     |
|  推回数据流  | PushbackInputStream  |                       |  PushbackReader   |                    |
|    特殊流    |   DataInputStream    |   DataOutputStream    |                   |                    |

#### 基础操作

1. 提供File类的对象，指明写出到的文件

2. 提供输入、输出流对象，用于数据的读写

3. 读写操作

4. 流资源的关闭

##### 输入操作：

###### InputStream ：结尾返回-1

* int read()
  * 从输入流中读取数据的下一个字节。
* int read(**byte[] b**)
  * 从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中。一般是1024
* int read(**byte[] b**, int off,int len)：
  * 将输入流中最多 len 个数据字节读入 byte 数组。尝试读取 len 个字节，但读取的字节也可能小于该值。
* public void close() throws IOException
  * 关闭此输入流并释放与该流关联的所有系统资源

###### Reader：结尾返回-1

* int read()
  * 从输入流中读取数据的下一个字节。
* int read(**char[] c**)
  * 将字符读入数组。一般是1024
* int read(**char[] c**, int off,int len)：
  * 将字符读入数组的某一部分。存到数组c中，从off处开始存储，最多读len个字符。
* public void close() throws IOException
  * 关闭此输入流并释放与该流关联的所有系统资源

```java
public void FileReaderTest() throws IOException {
	// 提供File类的对象，指明写出到的文件
    File file = new File(path + "\\Hello.txt");
    //提供输入、输出流对象，用于数据的读写
    FileReader reader = new FileReader(file);
    
    // 读写操作
    char[] c = new char[1024];
    int len;
    while ((len = reader.read(c)) != -1) { // 一组一组的读取，大小自己设定
    	System.out.print(new String(c, 0, len));
    }
    // 流资源的关闭
    reader.close();
    }
```

##### 输出操作：

###### OutputStream：

- void write(int b)
  - 将指定的字节写入此输出流。write 的常规协定是：向输出流写入一个字节。要写入的字节是参数 b 的八个低位。b 的 24 个高位将被忽略。 即写入0~255范围的。
- void write(byte[] b)
  - 将 b.length 个字节从指定的 byte 数组写入此输出流。
- void write(byte[] b,int off,int len)
  - 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。
- public void flush()throws IOException
  - 刷新此输出流并强制写出所有缓冲的输出字节，调用此方法指示应将这些字节立即写入它们预期的目标。
- public void close() throws IOException
  - 关闭此输出流并释放与该流关联的所有系统资源。

###### Writer：

-  void write(int c)
  - 写入单个字符。要写入的字符包含在给定整数值的 16 个低位中，16 高位被忽略。 即写入0 到 65535 之间的Unicode码。
- void write(char[] cbuf)
  - 写入字符数组。
- void write(char[] cbuf,int off,int len)
  - 写入字符数组的某一部分。从off开始，写入len个字符
- void write(String str)
  - 写入字符串。
- void write(String str,int off,int len)
  - 写入字符串的某一部分。
- void flush()
  - 刷新该流的缓冲，则立即将它们写入预期目标。
- public void close() throws IOException
  - 关闭此输出流并释放与该流关联的所有系统资源



```java
public void FileWriterTest() throws IOException {
    File file = new File(path + "\\Hello.txt");
    FileWriter fileWriter = new FileWriter(file, true);
    fileWriter.write("I have a dream!\n");
    fileWriter.write("you need to have a dream!");
    fileWriter.close();
}
```

##### 缓冲流：Buffered(Reader、Writer、InputStream、OutputStream)

```Java
public void testBufferedReaderBufferedWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

            //读写操作
            //方式一：使用char[]数组
			// char[] cbuf = new char[1024];
			// int len;
			// while((len = br.read(cbuf)) != -1){
			// 		bw.write(cbuf,0,len);
			// 		bw.flush();
			// }
            //方式二：使用String
            String data;
            while((data = br.readLine()) != null){
                bw.write(data);//data中不包含换行符
                bw.newLine();//提供换行的操作
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
```

##### 数据流

- 为了方便地操作Java语言的基本数据类型和String的数据，可以使用数据流。
- 数据流有两个类：(用于读取和写出基本数据类型、String类的数据）
- DataInputStream 中的方法[ DataOutputStream ]

| boolean readBoolean() [writeBoolean()] | boolean readBoolean()[writeBoolean()]           |
| -------------------------------------- | ----------------------------------------------- |
| char readChar()  [writeBoolean()]      | float readFloat()  [writeFloat()]               |
| double readDouble()   [writeDouble()]  | short readShort()  [writeShort()]               |
| long readLong()   [writeLong()]        | int readInt()  [writeInt()]                     |
| String readUTF()  [writeUTF()]         | void readFully(byte[] b) [writeFully(byte[] b)] |

```java
 public void test3() throws IOException {
     DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
     dos.writeUTF("刘建辰");
     dos.flush();//刷新操作，将内存中的数据写入文件
     dos.writeInt(23);
     dos.flush();
     dos.writeBoolean(true);
     dos.flush();

     dos.close();
}
public void test4() throws IOException {
    DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
    String name = dis.readUTF();
    int age = dis.readInt();
    boolean isMale = dis.readBoolean();
    
    System.out.println("name = " + name);
    System.out.println("age = " + age);
    System.out.println("isMale = " + isMale);

    dis.close();
}
```

对象流、RandomAccessFile 类

### NIO

Java NIO (New IO，Non-Blocking IO)是从Java 1.4版本开始引入的一套新的IO API，可以替代标准的Java IO API。NIO与原来的IO有同样的作用和目的，但是使用的方式完全不同，NIO支持面向缓冲区的(IO是面向流的)、基于通道的IO操作。NIO将以更加高效的方式进行文件的读写操作。