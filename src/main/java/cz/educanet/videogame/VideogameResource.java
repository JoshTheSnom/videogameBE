package cz.educanet.videogame;

import javax.inject.Inject;
import javax.swing.*;
import javax.ws.rs.*;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("videogames")
@Produces(MediaType.APPLICATION_JSON)
public class VideogameResource {
    @Inject
    VideogameManager videogameManager;

    @Inject
    LoginManager loginManager;

    @GET
    public Response getVideogames() {
        if (loginManager.loggers == null) return Response.status(Response.Status.UNAUTHORIZED).build();
        else {
            return Response.ok(videogameManager.getVideogames()).build();
        }

    }

    @GET
    @Path("{id}")
    public Response getOneVideogame(@PathParam("id") int id) {
        if (loginManager.loggers == null) return Response.status(Response.Status.UNAUTHORIZED).build();
        else {
            return Response.ok(videogameManager.getVideogameById(id)).build();
        }

    }

    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response addVideogame(Videogame videogame) {
        if (loginManager.loggers == null) return Response.status(Response.Status.UNAUTHORIZED).build();
        else {
            videogameManager.addVideogame(videogame);
            return Response.ok().build();
        }

    }

    @PUT
    @Path("{id}")
    public Response editVideogame(@PathParam("id") int id, Videogame videogame) {
        if (loginManager.loggers == null) return Response.status(Response.Status.UNAUTHORIZED).build();
        else {
            if (videogameManager.editVideogame(id, videogame)) {
                return Response.ok().build();
            } else return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

    @DELETE
    @Path("{id}")
    public Response deleteVideogame(@PathParam("id") int id) {
        if (loginManager.loggers == null) return Response.status(Response.Status.UNAUTHORIZED).build();
        else {
            if (videogameManager.deleteVideogame(id)) {
                return Response.ok().build();
            } else return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
}
