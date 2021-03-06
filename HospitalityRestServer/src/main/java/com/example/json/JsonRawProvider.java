package com.example.json;


import com.example.Constants;
import com.google.gson.*;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

/**
 * Provider that converts hive entity to JSON and JSON to hive entity
 */
@Provider
public class JsonRawProvider implements MessageBodyWriter<JsonObject>, MessageBodyReader<JsonObject> {


    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return MediaType.APPLICATION_JSON_TYPE.getType().equals(mediaType.getType()) && MediaType
                .APPLICATION_JSON_TYPE.getSubtype().equals(mediaType.getSubtype());
    }

    @Override
    public JsonObject readFrom(Class<JsonObject> type, Type genericType, Annotation[] annotations, MediaType mediaType,
                               MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
            throws IOException, WebApplicationException {
        JsonElement element = new JsonParser().parse(new InputStreamReader(entityStream,
                Charset.forName(Constants.UTF_8)));
        if (element.isJsonObject()) {
            return element.getAsJsonObject();
        }
        throw new IOException("Not a JSON object");
    }

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return MediaType.APPLICATION_JSON_TYPE.getType().equals(mediaType.getType()) && MediaType
                .APPLICATION_JSON_TYPE.getSubtype().equals(mediaType.getSubtype());
    }

    @Override
    public long getSize(JsonObject jsonObject, Class<?> type, Type genericType, Annotation[] annotations,
                        MediaType mediaType) {
        return 0;
    }

    @Override
    public void writeTo(JsonObject jsonObject, Class<?> type, Type genericType, Annotation[] annotations,
                        MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
            throws IOException, WebApplicationException {
        Gson gson = createGson();
        Writer writer = null;
        try {
            writer = new OutputStreamWriter(entityStream, Charset.forName(Constants.UTF_8));
            gson.toJson(jsonObject, writer);
        } finally {
            if (writer != null) {
                writer.flush();
            }
        }
    }

    private Gson createGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapterFactory(new NullableWrapperAdapterFactory())
                .create();
    }
}
