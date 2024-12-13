package ru.itis.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.itis.repository.DBConnection;


@WebListener
public class KrContextListener implements ServletContextListener {

    final static Logger logger = LogManager.getLogger(KrContextListener.class);

    public void contextInitialized(ServletContextEvent sce) {
        logger.info("contextInitialized");
        DBConnection.getInstance();
    }

    public void contextDestroyed(ServletContextEvent sce) {
        DBConnection.getInstance().destroy();
    }
}
