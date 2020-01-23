package com.arun.project.webapp;

import com.arun.project.webapp.entity.Entity;
import com.arun.project.webapp.entity.EntityType;
import com.arun.project.webapp.ext.EntityMessageBodyWriter;
import com.arun.project.webapp.ext.EntityTypeConverter;
import com.arun.project.webapp.media.MediaTypeExt;

import javax.ws.rs.*;

@Path("entity")
public class Resource {
    /**
     * URL http://ip:port/contextPath/entity/{entityType}?id={entityId}<br>
     * <p>
     * {@link EntityTypeConverter} provided to modify incoming test entityType to Object<br>
     * {@link EntityMessageBodyWriter} provided to write response as {@link EntityMessageBodyWriter} object<br>
     *
     * @param entityType URL param
     * @param entityID   Query Param
     * @return Entity Object
     */
    @GET
    @Produces(MediaTypeExt.JSON)
    public Entity get(@PathParam("entityType") EntityType entityType, @QueryParam("id") String entityID) {
        Entity e = null;
        return e;
    }


}
