package com.GameEngine.logic.resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Указывает библиотеке Log4j конфигурационный файл Log4j2.xml
 */
public class LoaderLog4jConfig {
    private static ClassLoader loader = LoaderLog4jConfig.class.getClassLoader();

    public static void loadConfig() {
        LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
        try {
            URI configLocation = loader.getResource("Log4j2.xml").toURI();
            context.setConfigLocation(configLocation);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
