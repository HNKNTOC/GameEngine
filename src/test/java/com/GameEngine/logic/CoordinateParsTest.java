package com.GameEngine.logic;

import com.GameEngine.logic.coordinate.Coordinate;
import com.GameEngine.logic.coordinate.CoordinatePars;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Тест для CoordinatePars.
 */
public class CoordinateParsTest {

    private int x;
    private int y;

    @Before
    public void setUp() throws Exception {
        x = new Random().nextInt(1000);
        y = new Random().nextInt(1000);
    }

    @Test
    public void parsCoordinate0() throws Exception {
        Coordinate coord = CoordinatePars.parsCoordinate(x + "," + y);
        assertNotNull(coord);
        assertTrue(coord.equals(new Coordinate(x, y)));
    }

    @Test
    public void parsCoordinate1() throws Exception {
        Coordinate coord = CoordinatePars.parsCoordinate(x + ";" + y, ";");
        assertNotNull(coord);
        assertTrue(coord.equals(new Coordinate(x, y)));
    }

    @Test
    public void parsCoordinateNull() throws Exception {
        Coordinate coord1 = CoordinatePars.parsCoordinate("test text");
        Coordinate coord2 = CoordinatePars.parsCoordinate("23 32");
        Coordinate coord3 = CoordinatePars.parsCoordinate("23;32");
        assertNull(coord1);
        assertNull(coord2);
        assertNull(coord3);
    }

}