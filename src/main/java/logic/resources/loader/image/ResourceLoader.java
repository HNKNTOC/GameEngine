package logic.resources.loader.image;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;

/**
 * Created by Nikita on 11.03.2016.
 */
public class ResourceLoader {

    private static ClassLoader loader;

    //private static final Logger logger = LogManager.getLogger(ResourceLoader.class);

    private ResourceLoader() {
        //logger.info("Create");
        loader = getClass().getClassLoader();
    }

    public static URL getResource(String nameResource) throws NullPointerException {
        //logger.debug("getResource - "+nameResource);
        checkLoader();
        URL url = loader.getResource(nameResource);
        if(url==null){
            NullPointerException e = new NullPointerException("ResourceLoader not find " + nameResource);
            //logger.warn("url==null",e);
            throw e;
        }
        return url;
    }

    /**
     * Проверяет loader на null если loader null создаёт его.
     */
    private static void checkLoader(){
        //logger.debug("checkLoader");
        if(loader==null){
            //logger.debug("loader==null new loader");
            loader = ResourceLoader.class.getClassLoader();
        }
    }
}