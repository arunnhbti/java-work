package com.arun.project.webapp.ext;

import com.arun.project.webapp.entity.Entity;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
public class EntityMessageBodyWriter implements MessageBodyWriter<Entity> {
    @Override
    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return Entity.class.isAssignableFrom(aClass);
    }

    @Override
    public void writeTo(Entity entity, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream) throws IOException, WebApplicationException {
        outputStream.write(entity.toString().getBytes());
    }

    @Deprecated
    @Override
    public long getSize(Entity entity, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }
}
