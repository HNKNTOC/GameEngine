package logic.resources;

import logic.resources.loader.image.ResourceLoader;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.*;

/**
 * Created by Nikita on 12.03.2016.
 */
public class ResourceLoaderTest {

    /**
     * Проверяет getResource на нохождение "null.jpg".
     * @throws Exception
     */
    @Test
    public void testGetResource() throws Exception {
        URL resource = ResourceLoader.getResource("image/null.jpg");
        assertTrue(resource!=null);
    }

    /**
     * Проверяет выкидывает ли getResource NullPointerException при неверно заданных параметрах.
     * @throws Exception
     */
    @Test
    public void testGetResourceNullPointerException() throws Exception {
        try {
            ResourceLoader.getResource("test");
        } catch (NullPointerException e) {
            assertTrue(true);
            return;
        }
        assertTrue(false);
    }
}