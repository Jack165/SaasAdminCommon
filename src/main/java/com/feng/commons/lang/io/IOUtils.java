package com.feng.commons.lang.io;

import com.feng.commons.lang.Charsets;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * io 工具
 *
 * @author bing_huang
 * @since 1.0.1
 */
public class IOUtils {
    public static final int EOF = -1;

    /**
     * 写入
     *
     * @param data   内容,不为<code>null</code>
     * @param output out流,不为<code>null</code>
     * @throws IOException io异常
     */
    public static void write(final byte[] data, final OutputStream output)
            throws IOException {
        if (null != data && null != output) {
            output.write(data);
        }
    }

    /**
     * 写入
     *
     * @param data     内容,不为<code>null</code>
     * @param output   out流,不为<code>null</code>
     * @param encoding 编码
     * @throws IOException io异常
     */
    public static void write(final char[] data, final OutputStream output, final String encoding)
            throws IOException {
        write(data, output, Charsets.toCharset(encoding));
    }

    /**
     * 写入
     *
     * @param data     内容,不为<code>null</code>
     * @param output   out流,不为<code>null</code>
     * @param encoding 编码
     * @throws IOException io异常
     */
    public static void write(final char[] data, final OutputStream output, final Charset encoding) throws IOException {
        if (null != data && null != output) {
            output.write(new String(data).getBytes(Charsets.toCharset(encoding)));
        }
    }

    /**
     * 写入
     *
     * @param data     内容
     * @param output   out流
     * @param encoding 编码
     * @throws IOException io异常
     */
    public static void write(final CharSequence data, final OutputStream output, final String encoding)
            throws IOException {
        write(data, output, Charsets.toCharset(encoding));
    }

    /**
     * 写入
     *
     * @param data     内容
     * @param output   out流
     * @param encoding 编码
     * @throws IOException io异常
     */
    public static void write(final CharSequence data, final OutputStream output, final Charset encoding)
            throws IOException {
        if (null != data && null != output) {
            write(data.toString(), output, encoding);
        }
    }

    /**
     * output流写
     *
     * @param data    内存，
     * @param out     outputStream,
     * @param charset 编码
     * @throws IOException io异常
     */
    public static void write(final String data, final OutputStream out, final Charset charset) throws IOException {
        if (null != data && null != out) {
            out.write(data.getBytes(Charsets.toCharset(charset)));
        }
    }


    /**
     * 关闭stream流
     *
     * @param output 可以为<code>null</code>或者已关闭
     */
    public static void closeQuietly(final OutputStream output) {
        closeQuietly((Closeable) output);
    }

    /**
     * 关闭流
     *
     * @param closeable 要关闭的对象，可能关闭或者为<code>null</code>
     */
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            // ignore
        }
    }

}
