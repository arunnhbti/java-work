package com.arun.project.webapp.provider;

import com.arun.project.webapp.entity.EntityType;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.Provider;
import java.util.Objects;

@Consumes(MediaType.TEXT_PLAIN)
@Provider
public class EntityTypeConverter implements ParamConverter<EntityType> {
    @Override
    public EntityType fromString(String entity) {
        EntityType entityType = new EntityType();
        entityType.setEntityType(entity);
        return entityType;
    }

    @Override
    public String toString(EntityType entityType) {
        Objects.requireNonNull(entityType, "EntityType cannot be null.");
        return entityType.getEntityType();
    }
}
