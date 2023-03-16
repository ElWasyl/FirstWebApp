package org.exercise;

import jakarta.annotation.Priority;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
@Priority(1)
public class UserDAOExceptionMapper implements ExceptionMapper<UserDAOException> {

    @Override
    public Response toResponse(UserDAOException exception) {
        String message = exception.getMessage();
        if (message.equals("Invalid authentication credentials")) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(Response.Status.UNAUTHORIZED + " : " + message).type(MediaType.TEXT_PLAIN).build();
        } else {
            return Response.status(Response.Status.CONFLICT).entity(Response.Status.CONFLICT + " : " + message).type(MediaType.TEXT_PLAIN).build();
        }
    }

}