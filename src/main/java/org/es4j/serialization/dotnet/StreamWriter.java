package org.es4j.serialization.dotnet;

import java.io.Closeable;
import java.io.IOException;
import org.es4j.dotnet.streams.Stream;


public class StreamWriter implements Closeable {

    public StreamWriter(Stream output, Encoding encoding) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
