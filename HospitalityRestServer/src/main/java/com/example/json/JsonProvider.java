package com.example.json;

import com.example.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
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
 * Created by Gleichmut on 5/3/2014.
 */
//@Provider
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
public class JsonProvider<T> implements MessageBodyReader<T>, MessageBodyWriter<T> {

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return MediaType.APPLICATION_JSON.equals(mediaType.getType()) &&
                MediaType.APPLICATION_JSON.equals(mediaType.getSubtype());
    }

    @Override
    public T readFrom(Class<T> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        Gson gson = createGson();
        Reader reader = new InputStreamReader(entityStream, Charset.forName(Constants.UTF_8));
        return gson.fromJson(reader, genericType);
    }

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return MediaType.APPLICATION_JSON.equals(mediaType.getType()) &&
                MediaType.APPLICATION_JSON.equals(mediaType.getSubtype());
    }

    @Override
    public long getSize(T t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(T t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        Gson gson = createGson();
        JsonElement element = gson.toJsonTree(entityStream);
        Writer writer = null;
        try {
            writer = new OutputStreamWriter(entityStream, Charset.forName(Constants.UTF_8));
            gson.toJson(element, writer);
        } finally {
            if (writer != null) {
                writer.flush();
            }
        }
    }

    private Gson createGson() {
        return new GsonBuilder().setPrettyPrinting().create();
    }
}
