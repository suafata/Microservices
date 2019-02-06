package com.suafata.order;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;

@Category(DockerIntegrationTest.class)
public class OrderApplicationTests {

	@Test
	public void getOrder() throws IOException {
		String base = System.getProperty("service.url");
		URL url = new URL(base + "");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		int response = connection.getResponseCode();
		assertEquals(200,response);
	}

}

