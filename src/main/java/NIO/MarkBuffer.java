package NIO;

import java.nio.ByteBuffer;

/**
 * @ClassName MarkBuffer
 * @Description TODO
 * @Author zhukq
 * @Date 2020/4/6 17:05
 * @Version 1.0
 */
public class MarkBuffer {
    public static void main(String[] args) {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        String str = "abcd1";
        buf.put(str.getBytes());
        // 开启读取模式
        buf.flip();
        byte[] dst = new byte[buf.limit()];
        buf.get(dst, 0, 2);
        //mark //为某一读过的位置做标记，便于某些时候回退到该位置。
        buf.mark();
        System.out.println(new String(dst, 0, 2));
        System.out.println(buf.position());
        buf.get(dst, 2, 2);
        System.out.println(new String(dst, 2, 2));
        System.out.println(buf.position());
        buf.reset();
        System.out.println("重置恢复到mark位置..");
        System.out.println(buf.position());

    }
}
