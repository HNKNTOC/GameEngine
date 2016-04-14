package com.GameEngine.logic.resources.manager;

import com.GameEngine.logic.resources.ImageName;
import com.GameEngine.logic.resources.loader.image.ImageLoader;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by Nikita on 14.04.2016.
 */
public class ResManagerTest {

    private ResManager resManager = ResManager.getResManager();

    @Test
    public void putAndGetImageIconNULLDescription() throws Exception {
        String imageName1 = ImageName.NULL;
        ImageIcon image = ImageLoader.getImage(imageName1);
        image.setDescription(null);
        String returnKey1 = resManager.putImageIcon(image);
        image.setDescription(null);
        String returnKey2 = resManager.putImageIcon(image);
        image.setDescription(null);
        String returnKey3 = resManager.putImageIcon(image);

        assertTrue(resManager.getImageIcon(returnKey1) == image &
                resManager.getImageIcon(returnKey2) == image &
                resManager.getImageIcon(returnKey3) == image);
    }

    @Test
    public void putAndGetImageIcon() throws Exception {
        String imageName1 = ImageName.CELL;
        ImageIcon image = ImageLoader.getImage(imageName1);
        String returnKey1 = resManager.putImageIcon(image);

        assertTrue(returnKey1.equals(imageName1));

        ImageIcon returnImage = resManager.getImageIcon(imageName1);
        assertTrue(returnImage == image);
    }

    /**
     * Проверка того что getResManager возвращает один и тот же объект.
     *
     * @throws Exception
     */
    @Test
    public void getResManager() throws Exception {
        ResManager[] resManagers = new ResManager[5];
        for (int i = 0; i < 5; i++) {
            resManagers[i] = ResManager.getResManager();
        }
        ResManager resManager = ResManager.getResManager();
        for (int i = 0; i < 5; i++) {
            assertTrue(resManager == resManagers[i]);
        }
    }

}