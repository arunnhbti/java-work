package com.arun.project.webapp.ext;

import com.arun.project.webapp.entity.EntityType;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.Provider;
import java.util.Objects;

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
