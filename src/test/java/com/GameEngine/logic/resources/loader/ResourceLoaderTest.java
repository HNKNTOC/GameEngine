package com.GameEngine.logic.resources.loader;

import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.assertTrue;

/**
 * Тест для ResourceLoaderTest.
 */
public class ResourceLoaderTest {

    /**
     * Проверяет getResource на нохождение "null.jpg".
     *
     * @throws Exception
     */
    @Test
    public void testGetResource() throws Exception {
        URL resource = ResourceLoader.getResource("image/null.jpg");
        assertTrue(resource != null);
    }

    /**
     * Проверяет выкидывает ли getResource NullPointerException при неверно заданных параметрах.
     */
    @Test(expected = NullPointerException.class)
    public void testGetException() {
        ResourceLoader.getResource("test");

    }
}