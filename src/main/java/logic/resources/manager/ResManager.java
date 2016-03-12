package logic.resources.manager;

import javax.swing.*;
import java.util.HashMap;

/**
 * Нужен для удобного полечения ресурсов.
 * Обиночка
 */
public class ResManager {
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
    }

    public ImageIcon getImageIcon(int id){
        return map.get(id);
    }

    public void putImageIcon(ImageIcon image){
        map.put(thisIdImageIcon,image);
        thisIdImageIcon++;
    }

    public static ResManager getResManager(){
        if(resManager==null){
            resManager = new ResManager();
        }
        return resManager;
    }

}
