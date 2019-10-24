package com.example.heroku;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * A single resource class which should be registered on the server using
 * registerClasses
 * 
 * @author cleber
 *
 */
@Path("/")
public class MyResource {

	/**
	 * Method returning a simple resource as text plain
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getRoot() {

		try {
			return Response.ok("Smile, jersey has been deployed!").build();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Response.status(500).build();
	}

	/**
	 * Another method returning a simple resource as text plain
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@Path("/myresource")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMyResource() {

		try {
			return Response.ok("Hello, Heroku!").build();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Response.status(500).build();
	}
}
