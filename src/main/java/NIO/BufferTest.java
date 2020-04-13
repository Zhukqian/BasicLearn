package NIO;

import java.nio.ByteBuffer;

/**
 * @ClassName BufferTest
 * @Description 　0 <= mark <= position <= limit <= capacity
 * @Author zhukq
 *
 *      byte[] buff  //buff即内部用于缓存的数组。
 *      position //当前读取的位置。
 *      mark //为某一读过的位置做标记，便于某些时候回退到该位置。
 *      capacity //初始化时候的容量。
 *      limit //当写数据到buffer中时，limit一般和capacity相等，当读数据时，limit代表buffer中有效数据的长度。
 *
 *
 *      put
 * 写模式下，往buffer里写一个字节，并把postion移动一位。写模式下，一般limit与capacity相等。
 * flip
 * 写完数据，需要开始读的时候，将postion复位到0，并将limit设为当前postion。
 * get
 * 从buffer里读一个字节，并把postion移动一位。上限是limit，即写入数据的最后位置。
 * clear
 * 将position置为0，并不清除buffer内容。
 * mark & reset
 * mark相关的方法主要是mark()(标记)和reset()(回到标记).
 *
 * @Date 2020/4/6 14:37
 *  * 缓冲区管理的方式 几乎都是
 *  * 通过allocate（） 获取缓冲区 
 *  * 二、缓冲区核心的方法 put 存入数据到缓冲区 get 获取缓冲区数据 flip 开启读模式
 *  * 三、缓冲区四个核心属性
 *  * capacity:缓冲区最大容量，一旦声明不能改变。 limit:界面(缓冲区可以操作的数据大小) limit后面的数据不能读写。
 *  * position:缓冲区正在操作的位置
 * @Version 1.0
 */
public class BufferTest {
    public static void main(String[] args) {
        // 1.指定缓冲区大小1024
        ByteBuffer buf = ByteBuffer.allocate(1024);
        System.out.println("--------------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        // 2.向缓冲区存放5个数据
        buf.put("abcd1".getBytes());
        System.out.println("--------------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        // 3.开启读模式
        buf.flip();
        System.out.println("----------开启读模式...----------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        byte[] bytes = new byte[buf.limit()];
        buf.get(bytes);
        System.out.println(new String(bytes, 0, bytes.length));
        System.out.println("----------重复读模式...----------");
        // 4.开启重复读模式
        //如果不开启重复度,将回从5开始读,我们要向从1开始读,就要调用,remind()
        buf.rewind();
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        byte[] bytes2 = new byte[buf.limit()];
        buf.get(bytes2);
        System.out.println(new String(bytes2, 0, bytes2.length));
        // 5.clean 清空缓冲区  数据依然存在,只不过数据被遗忘
        System.out.println("----------清空缓冲区...----------");
        buf.clear();
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        //清空之后依旧能够取出来,只是把下标界限给还原了,值依旧存在,只不过数据被遗忘
        System.out.println((char)buf.get());
    }


}
