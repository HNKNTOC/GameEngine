package logic.resources.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.util.HashMap;

/**
 * Нужен для удобного полечения ресурсов.
 * Обиночка
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
        logger.info("Create");
    }

    public ImageIcon getImageIcon(int id){
        logger.debug("getImageIcon");
        return map.get(id);
    }

    public void putImageIcon(ImageIcon image){
        map.put(thisIdImageIcon,image);
        thisIdImageIcon++;
        logger.debug("putImageIcon id="+thisIdImageIcon);
    }

    public static ResManager getResManager(){
        if(resManager==null){
            resManager = new ResManager();
        }
        return resManager;
    }

}
