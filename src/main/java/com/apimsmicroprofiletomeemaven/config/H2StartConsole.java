/**
 * 
 */
package com.apimsmicroprofiletomeemaven.config;

import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.h2.tools.Server;

/**
 * Class that loads and launches the H2 console.
 * 
 * Obs: This class is the cat's leap !!! huahuahuahuahua
 * 
 * @author eloi eloibilek@gmail.com
 */
@WebListener
public class H2StartConsole implements ServletContextListener {

	static final Logger LOGGER = Logger.getLogger(H2StartConsole.class.getName());

	private Server server;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			server = Server.createWebServer("-webPort", "8082", "-webAllowOthers").start();
			LOGGER.info(":::::::::: Init H2 Sever Console: " + server.getURL());
		} catch (SQLException e) {
			LOGGER.severe(e.getMessage());
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		server.shutdown();
	}

}
