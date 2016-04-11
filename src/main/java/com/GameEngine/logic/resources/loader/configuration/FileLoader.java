package com.GameEngine.logic.resources.loader.configuration;

import com.GameEngine.logic.resources.loader.ResourceLoader;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Данный класс нужен для упрощения получения File.
 * FileLoader ищет файлы с помощью ResourceLoader.
 */
public class FileLoader {
    /**
     * С помощью ResourceLoader ищет файл name и преобразует его в File.
     *
     * @param name имя файла к примеру "test.txt".
     * @return найденный файл. null если файл не был найден.
     * @throws NullPointerException если найти не удалось.
     */
    public static File getFile(String name) throws NullPointerException {
        File file = null;
        try {
            file = new File(ResourceLoader.getResource(name).toURI());
        } catch (URISyntaxException e) {
            return null;
        } catch (NullPointerException e) {
            throw e;
        }
        return file;
    }
}
