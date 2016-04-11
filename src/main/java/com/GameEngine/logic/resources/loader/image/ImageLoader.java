package com.GameEngine.logic.resources.loader.image;

import com.GameEngine.logic.resources.loader.ResourceLoader;

import javax.swing.*;

/**
 * Данный класс нужен для упрощения получения Image.
 * ImageLoader ищет Image с помощью ResourceLoader.
 */
public class ImageLoader {
    /**
     * С помощью ResourceLoader ищет файл name и преобразует его в ImageIcon.
     * @param name имя картинки к примеру "image.png".
     * @return найденную картинку.
     * @throws NullPointerException если найти не удалось.
     */
    public static ImageIcon getImage(String name) throws NullPointerException{
        ImageIcon imageIcon = new ImageIcon(ResourceLoader.getResource("image/"+ name));
        imageIcon.setDescription(name);
        return imageIcon;
    }

}
