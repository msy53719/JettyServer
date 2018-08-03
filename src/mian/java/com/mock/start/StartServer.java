package com.mock.start;

import java.util.regex.Pattern;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartServer {
	private static Logger logger = LoggerFactory.getLogger(StartServer.class);

	public static int checkPort(String port) {
		Pattern pattern = Pattern.compile("^[1-9]\\d{2,8}$");
		if (pattern.matcher(port).equals("true")) {
			return Integer.valueOf(port);
		} else {

			return Integer.valueOf("8080");
		}
	}

	public static void main(String[] args) {
		String port = System.getProperty("port");
		int po = checkPort(port);
		System.out.println(po);
		logger.debug("端口号：{}", po);
		Integer.valueOf(po);
		Server server=new Server(po);
		ServletContextHandler context=new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
		
		
	}

}
