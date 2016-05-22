package com.GameEngine.logic.resources;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import java.net.URL;

/**
 * Указывает библиотеке Log4j конфигурационный файл Log4j2.xml
 */
public class LoaderLog4jConfig {
    private static ClassLoader loader = LoaderLog4jConfig.class.getClassLoader();

    public static void loadConfig() {
        BasicConfigurator.configure();
        URL resource = loader.getResource("Log4j.xml");
        if (resource == null) {
            System.out.println("Not find Log4j.xml");
            return;
        }
        DOMConfigurator.configure(resource);
    }
}
