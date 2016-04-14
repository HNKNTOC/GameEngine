package com.GameEngine.logic.resources.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.util.HashMap;

/**
 * Нужен для удобного получения ресурсов.
 * Хранит картинки в HashMap к каждой картинке есть name ключ с помощью которого можно получить эту картинку.
 *
 * ResManager является одиночкой
 */
public class ResManager {
    private static final Logger logger = LogManager.getLogger(ResManager.class);
    /**
     * Ссылка на себя.
     */
    private static ResManager resManager;
    /**
     * HashMap в котором хранятся ImageIcon
     */
    private HashMap<String, ImageIcon> map;

    private ResManager() {
        map = new HashMap<>();
        logger.info("Create ResManager");
    }

    /**
     * Получить картинку по её ключу id.
     *
     * @param name ключ картинки.
     * @return картинка соответствующая этому ключу.
     * null если ключ не соответствует картинке.
     */
    public ImageIcon getImageIcon(String name) {
        ImageIcon image = map.get(name);
        logger.debug("getImageIcon " + image + " name=" + name);
        return image;
    }

    /**
     * Добавляет картинку.
     * За ключ для получения картинки берется её описание.
     * Если описание == null создаётся описание для картинки типа image_*;
     * @param image картинку которую нужно добавить.
     * @return ключ картинки по которому можно получить её.
     */
    public String putImageIcon(ImageIcon image) {
        String description = image.getDescription();
        if (description == null) {
            description = createDescription();
            image.setDescription(description);
        }
        map.put(image.getDescription(), image);
        logger.debug("putImageIcon " + image + " name=" + description);
        return description;
    }

    /**
     * Создаёт описание и возвращает его.
     *
     * @return созданное описание.
     */
    private String createDescription() {
        return "image_" + (map.size() + 1);
    }

    public static ResManager getResManager(){
        if(resManager==null){
            resManager = new ResManager();
        }
        return resManager;
    }

}
