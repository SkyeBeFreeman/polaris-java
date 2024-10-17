package com.tencent.polaris.client.util;

import java.io.IOException;
import java.io.Writer;

/**
 * 测试过这个类，对中文有效，对处于 Plane 1 的字符（如 𐀀）也有效
 *
 * @author onlyicelin
 */
public class EscapeNonAsciiWriter extends Writer {
    private final Writer out;

    public EscapeNonAsciiWriter(Writer out) {
        this.out = out;
    }

    @Override
    public void write(char[] buffer, int offset, int count) throws IOException {
        for (int i = 0; i < count; i++) {
            char c = buffer[i + offset];
            if (c <= 0x7f) {
                out.write(c);
            } else {
                out.write(String.format("\\u%04x", (int) c));
            }
        }
    }

    @Override
    public void flush() throws IOException {
        out.flush();
    }

    @Override
    public void close() throws IOException {
        out.close();
    }
}
