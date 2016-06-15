package com.userm;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/UserService")
public class UserService {

    private static final String SUCCESS_RESULT="<result>success</result>";
    private static final String FAILURE_RESULT="<result>failure</result>";

    private SendInterface message;
    private UserDaoInterface userdao;

    @Inject
    public UserService(SendInterface message, UserDaoInterface userdao) {
        this.message = message;
        this.userdao = userdao;
    }

    @GET
    @Path("/users")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<User> getUsers() {
        return userdao.getAllUsers();
    }

    @GET
    @Path("/users/{userid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User getUser(@PathParam("userid") int userid){
        return userdao.getUser(userid);
    }

    @PUT
    @Path("/users")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String createUser(@FormParam("id") int id,
        @FormParam("name") String name,
        @FormParam("profession") String profession,
        @Context HttpServletResponse servletResponse) throws IOException{
        User user = new User(id, name, profession);
        int result = userdao.addUser(user);
        if(result == 1){
            message.message("PUT");
            return SUCCESS_RESULT;
        }
        return FAILURE_RESULT;
    }

    @POST
    @Path("/users")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String updateUser(@FormParam("id") int id,
                             @FormParam("name") String name,
                             @FormParam("profession") String profession,
                             @Context HttpServletResponse servletResponse) throws IOException{
        User user = new User(id, name, profession);
        int result = userdao.updateUser(user);
        if(result == 1){
            message.message("POST");
            return SUCCESS_RESULT;
        }
        return FAILURE_RESULT;
    }

    @DELETE
    @Path("/users/{userid}")
    @Produces(MediaType.APPLICATION_XML)
    public String deleteUser(@PathParam("userid") int userid) throws IOException {
        int result = userdao.deleteUser(userid);
        if(result == 1){
            message.message("DELETE");
            return SUCCESS_RESULT;
        }
        return FAILURE_RESULT;
    }

    @OPTIONS
    @Path("/users")
    @Produces(MediaType.APPLICATION_XML)
    public String getSupportedOperations(){
        return "<operations>GET, PUT, POST, DELETE</operations>";
    }
}
