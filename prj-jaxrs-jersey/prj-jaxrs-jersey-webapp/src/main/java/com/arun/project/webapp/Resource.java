package com.arun.project.webapp;

import com.arun.project.webapp.entity.Entity;
import com.arun.project.webapp.entity.EntityType;
import com.arun.project.webapp.media.MediaTypeExt;

import javax.ws.rs.*;

@Path("entity")
public class Resource {
    @GET
    @Produces(MediaTypeExt.JSON)
    public Entity get(@PathParam("entityType") EntityType entityType, @QueryParam("id") String entityID) {
        Entity e = null;
        return e;
    }
}
