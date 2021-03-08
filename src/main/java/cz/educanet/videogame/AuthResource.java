package cz.educanet.videogame;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("authentication")
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {
    @Inject
    private UserManager userManager;

    @Inject
    private LoginManager loginManager;

    @Path("/register")
    @POST
    public Response register(User tempUser) {

        if (userManager.existByUsername(tempUser.getUsername())) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Týpeček existuje").build();
        } else {
            userManager.userAdd(tempUser);
            return Response.ok("týpeček byl vytvořen").build();

        }
    }

    @Path("/login")
    @POST
    public Response login(User user) {
        User tempUser = userManager.getUserByUsernameAndPass(user.getUsername(), user.getPassword());
        if (tempUser == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("týpeček neexistuje").build();
        } else {
            loginManager.loggers = tempUser;
            return Response.ok("týpeček byl přihlášen").build();
        }
    }

    @Path("/logout")
    @DELETE
    public Response logout() {
        loginManager.loggers = null;
        return Response.ok("týpeček byl úspěšně odhlášen").build();
    }
}