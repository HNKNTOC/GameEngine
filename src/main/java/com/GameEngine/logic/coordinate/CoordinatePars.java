package com.GameEngine.logic.coordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * Переводит координаты из различных форматов в объект Coordinate для удобства.
 */
public class CoordinatePars {
    /**
     * Из форматы String в Coordinate.
     *
     * @param coord     строка вида "x"+separator+"y".
     * @param separator разделитель x и y.
     * @return спасенный Coordinate. null если спарить не получилось.
     */
    public static Coordinate parsCoordinate(String coord, String separator) {
        String[] split = coord.split(separator);
        if (split.length != 2) return null;
        return new Coordinate(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }

    /**
     * Из форматы String в Coordinate разделителем по умолчанию является ",".
     *
     * @param coord строка вида "x,y".
     * @return спасенный Coordinate. null если спарить не получилось.
     */
    public static Coordinate parsCoordinate(String coord) {
        return parsCoordinate(coord, ",");
    }

    /**
     * Из форматы String в Coordinate.
     *
     * @param coordList строка вида "x,y".
     * @return спасенный Coordinate. null если спарить не получилось.
     */
    public static List<Coordinate> parsListCoordinate(List<String> coordList, String separator) {
        List<Coordinate> coords = new ArrayList<>();
        for (String s : coordList) {
            coords.add(CoordinatePars.parsCoordinate(s, separator));
        }
        return coords;
    }

    /**
     * Из форматы String в Coordinate разделителем по умолчанию является ",".
     *
     * @param coordList строка вида "x,y".
     * @return спасенный Coordinate. null если спарить не получилось.
     */
    public static List<Coordinate> parsListCoordinate(List<String> coordList) {
        return parsListCoordinate(coordList, ",");
    }
}
