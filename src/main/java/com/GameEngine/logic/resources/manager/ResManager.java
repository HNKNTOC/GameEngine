package logic.resources.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.util.HashMap;

/**
 * Нужен для удобного получения ресурсов.
 * Хранит картинки в HashMap к каждой картинке есть id ключ с помощью которого можно получить эту картинку.
 *
 * Одиночка
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
    private HashMap<Integer,ImageIcon> map;
    /**
     * Id которое будет присуждена следующему добавленной картинке.
     */
    private int thisIdImageIcon;

    private ResManager() {
        map = new HashMap<>();
        logger.info("Create ResManager");
    }

    /**
     * Получить картинку по её ключу id.
     *
     * @param id ключ картинки.
     * @return картинка соответствующая этому ключу.
     * null если ключ не соответствует картинке.
     */
    public ImageIcon getImageIcon(int id){
        logger.debug("getImageIcon id=" + id);
        return map.get(id);
    }

    /**
     * Добавляет картинку.
     *
     * @param image картинку которую нужно добавить.
     * @return ключ картинки по которому можно получить её.
     */
    public int putImageIcon(ImageIcon image){
        map.put(thisIdImageIcon,image);
        thisIdImageIcon++;
        logger.debug("putImageIcon id="+thisIdImageIcon);
        return thisIdImageIcon;
    }

    public static ResManager getResManager(){
        if(resManager==null){
            resManager = new ResManager();
        }
        return resManager;
    }

}
