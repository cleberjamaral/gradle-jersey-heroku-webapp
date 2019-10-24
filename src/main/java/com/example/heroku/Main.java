package com.example.heroku;

import java.net.InetAddress;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * This is a simple project that shows a deploy of a Restfull service providing
 * two simple resources using gradle. I did that because I did not find a
 * tutorial deploying jersey with gradle. All necessary dependencies are being
 * copied to /build/libs folder for heroku use.
 * 
 * If it works, after deploying in heroku, accessing the root resource will give you
 * a simple text message. Acessing /myresource will give another simple message.
 * 
 * Currently I have added 10 dependencies, maybe there are libs that are not
 * really necessary, it needs a better investigation.
 * 
 * This sample project is based on jersey documentation
 * https://eclipse-ee4j.github.io/jersey.github.io/documentation/latest/getting-started.html#deploy-it-on-heroku,
 * @mgajdos simple heroku webapp using maven https://github.com/mgajdos/jersey-simple-heroku-webapp, heroku
 * gradle documentation https://devcenter.heroku.com/articles/deploying-gradle-apps-on-heroku,
 * and gradle getting started example developed by @jkutner which uses spring-boot 
 * https://github.com/heroku/gradle-getting-started
 * 
 * @author cleber
 *
 */
public class Main {
	static URI restServerURI = null;

	/**
	 * Main call makes server run
	 * 
	 * @param args not really used in this project
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {

		String webPort = System.getenv("PORT");
		if (webPort == null || webPort.isEmpty()) {
			webPort = "8080";
		}

		HttpServer restHttpServer = startRestServer(Integer.parseInt(webPort));
	}

	/**
	 * Start a server in a given port (port read from .env file)
	 * 
	 * @param port where server will run (by default 8080)
	 * @return an http server
	 */
	public static HttpServer startRestServer(int port) {
		try {
			restServerURI = UriBuilder.fromUri("http://" + InetAddress.getLocalHost().getHostAddress() + "/").port(port)
					.build();

			ResourceConfig rc = new ResourceConfig();
			rc.registerClasses(MyResource.class);

			HttpServer s = GrizzlyHttpServerFactory.createHttpServer(restServerURI, rc);
			System.out.println("Rest API is running on " + restServerURI + "\n");
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
