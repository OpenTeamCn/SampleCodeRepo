/**
 * 
 */
package com.openteam.jersey.samp;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author tgu011
 *
 */
public class MyResourceTest {

	public static final String BASE_URI = "http://2.openapptest.duapp.com/webapi/";
	private WebTarget target;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// create the client
        Client c = ClientBuilder.newClient();
        target = c.target(BASE_URI);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.openteam.jersey.samp.MyResource#getIt()}.
	 */
	@Test
	public void testGetIt() {
		String responseMsg = target.path("myresource").request().get(String.class);
        assertEquals("Got it!", responseMsg);
	}

}
