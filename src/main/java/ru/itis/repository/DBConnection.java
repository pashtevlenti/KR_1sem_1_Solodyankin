package ru.itis.repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    final static Logger logger = LogManager.getLogger(DBConnection.class);

    private static DBConnection instance;

    private static HikariDataSource dataSource;

    private DBConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File("C:\\Users\\79195\\Desktop\\IdeaProjects\\2_course\\KR_1sem_1_Solodyankin\\src\\main\\resources\\db.properties")));

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(properties.getProperty("db.url"));
            config.setUsername(properties.getProperty("db.username"));
            config.setPassword(properties.getProperty("db.password"));
            config.setConnectionTimeout(50000);
            config.setMaximumPoolSize(10);

            dataSource = new HikariDataSource(config);
            Flyway flyway = Flyway.configure().dataSource(dataSource).load();
            logger.info("start migration");
            flyway.baseline();
            flyway.migrate();
            logger.info("migration done");
        } catch (ClassNotFoundException | FlywayException e) {
            logger.error("", e);
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            synchronized (DBConnection.class) {
                if (instance == null) {
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }

    public synchronized Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }

    public synchronized void releasConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public void destroy() {
        dataSource.close();
    }
}
