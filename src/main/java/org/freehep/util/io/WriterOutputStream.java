// Copyright 2003, FreeHEP.
package org.freehep.util.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/**
 * The WriterOutputStream makes a Writer look like an OutputStream.
 * 
 * @author Mark Donszelmann
 * @version $Id: WriterOutputStream.java 8584 2006-08-10 23:06:37Z duns $
 */
public class WriterOutputStream extends OutputStream {

    private Writer writer;

    /**
     * Create an Output Stream from given Writer.
     * 
     * @param writer writer to write to
     */
    public WriterOutputStream(Writer writer) {
        this.writer = writer;
    }

    public void write(int b) throws IOException {
        writer.write(b & 0xFF);
    }

    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        for (int i = 0; i < len; i++) {
            writer.write(b[off + i]);
        }
    }

    public void close() throws IOException {
        writer.close();
    }

    public void flush() throws IOException {
        writer.flush();
    }
}