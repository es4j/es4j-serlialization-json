package org.es4j.serialization.dotnet;

/**
 *
 * @author Esfand
 */
public class JsonNetSerializer {

    TypeNameHandling      typeNameHandling; //.Auto,
    DefaultValueHandling  defaultValueHandling; //.Ignore,
    NullValueHandling     nullValueHandling; //.Ignore};

    public JsonNetSerializer(TypeNameHandling typeNameHandling, DefaultValueHandling defaultValueHandling, NullValueHandling nullValueHandling) {
        this.typeNameHandling     = typeNameHandling;
        this.defaultValueHandling = defaultValueHandling;
        this.nullValueHandling    = nullValueHandling;
    }



}
