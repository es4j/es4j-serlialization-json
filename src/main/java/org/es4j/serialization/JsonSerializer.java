package org.es4j.serialization;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.es4j.dotnet.Stream;
import org.es4j.serialization.api.ISerialize;
import org.es4j.serialization.dotnet.*;
import org.es4j.serialization.json.Messages;
import org.es4j.util.GenericType;
import org.es4j.util.logging.ILog;
import org.es4j.util.logging.LogFactory;

//using System;
//using System.Collections.Generic;
//using System.IO;
//using System.Linq;
//using System.Text;
//using Logging;
//using Newtonsoft.Json;
//using JsonNetSerializer = Newtonsoft.Json.JsonSerializer;


public class JsonSerializer implements ISerialize {

    private static final ILog logger = LogFactory.buildLogger(JsonSerializer.class);

    private final JsonNetSerializer untypedSerializer = new JsonNetSerializer(TypeNameHandling.Auto,
                                                                              DefaultValueHandling.Ignore,
                                                                              NullValueHandling.Ignore);

    private final JsonNetSerializer typedSerializer   = new JsonNetSerializer(TypeNameHandling.All,
                                                                              DefaultValueHandling.Ignore,
                                                                              NullValueHandling.Ignore);

    private /*final*/ List<Class> knownTypes; // = Arrays.asList( //List<EventMessageEventMessage>.class,
			                                      //Map<String, Object>.class)
                                              //              );

    public JsonSerializer(List<Class> knownTypes) {
        this.knownTypes = Arrays.asList( //List<EventMessageEventMessage>.class,
			            //Map<String, Object>.class)
                                   );
        if (knownTypes != null && !knownTypes.iterator().hasNext()) {
            knownTypes = null;
        }
        this.knownTypes = (knownTypes!=null)? knownTypes : this.knownTypes;

        for (Class type : this.knownTypes) {
            logger.debug(Messages.RegisteringKnownType(), type);
        }
    }

    public JsonSerializer() {
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override // virtual
    public <T> void serialize(Stream output, T graph) {
        //throw new UnsupportedOperationException("Not yet implemented");
        logger.verbose(Messages.SerializingGraph(), graph.getClass().getName());
        try/*using*/ (StreamWriter streamWriter = new StreamWriter(output, Encoding.UTF8)) {
            this.serialize(new JsonTextWriter(streamWriter), graph);
        }
        catch(IOException ex) {

        }
    }

    // virtual
    protected void serialize(JsonWriter writer, Object graph) {
        //try/*using*/ (writer) {
        //   this.getSerializer(graph.getClass()).serialize(writer, graph);
        //}
    }

    // virtual
    @Override
    public <T> T deserialize(Stream input, GenericType<T> type) {
        throw new UnsupportedOperationException("Not yet implemented");
        //logger.verbose(Messages.DeserializingStream(), typeof(T));
        //try/*using*/ (StreamReader streamReader = new StreamReader(input, Encoding.UTF8)) {
        //   return this.deserialize/*<T>*/(new JsonTextReader(streamReader));
        //}
    }

    // virtual
    protected <T> T deserialize(JsonReader reader) {
        throw new UnsupportedOperationException("Not yet implemented");
        //T type = typeof(T);
        //try/*using*/ (reader) {
        //   return (T)this.getSerializer(type).deserialize(reader, type);
        //}
    }

    // virtual
    protected JsonNetSerializer getSerializer(Class typeToSerialize) {
        if (this.knownTypes.contains(typeToSerialize)) {
            logger.verbose(Messages.UsingUntypedSerializer(), typeToSerialize);
            return this.untypedSerializer;
        }
        logger.verbose(Messages.UsingTypedSerializer(), typeToSerialize);
        return this.typedSerializer;
    }
}
