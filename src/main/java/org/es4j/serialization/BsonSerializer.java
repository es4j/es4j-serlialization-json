package org.es4j.serialization;

//using System;

import java.util.List;
import org.es4j.dotnet.Stream;
import org.es4j.util.GenericType;
import org.es4j.util.logging.ILog;
import org.es4j.util.logging.LogFactory;

//using System.IO;
//using Newtonsoft.Json.Bson;


public class BsonSerializer extends JsonSerializer {

    private static final ILog logger = LogFactory.buildLogger(BsonSerializer.class);

    public BsonSerializer(/*params*/ List<Class> knownTypes) {
        super(knownTypes);
    }

    public BsonSerializer() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public <T> void serialize(Stream output, T graph) {
        throw new UnsupportedOperationException("Not yet implemented");
        //BsonWriter writer = new BsonWriter(output, DateTimeKind.Utc);
        //this.serialize(writer, graph);
    }

    @Override
    public <T> T deserialize(Stream input, GenericType<T> type) {
        throw new UnsupportedOperationException("Not yet implemented");
        //BsonReader reader = new BsonReader(input, IsArray(typeof(T)), DateTimeKind.Utc);
        //throw new UnsupportedOperationException("Not yet implemented");
        //return this.deserialize/*<T>*/(reader);
    }

    private static boolean isArray(Class type) {
        throw new UnsupportedOperationException("Not yet implemented");
        //boolean array = typeof(Iterable).isAssignableFrom(type) && !typeof(Map).isAssignableFrom(type);
        //logger.verbose(Messages.TypeIsArray(), type, array);
        //return array;
    }

}