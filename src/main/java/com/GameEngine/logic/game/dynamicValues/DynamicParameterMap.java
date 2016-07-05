package com.GameEngine.logic.game.dynamicValues;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;

/**
 * Реализация DynamicParameter через HashMap.
 */
public class DynamicParameterMap implements DynamicParameter {
    private HashMap<String, String> mapParameter;
    private static final Logger logger = LogManager.getLogger(DynamicParameterMap.class);
    /**
     * Уникальный id.
     */
    private final int id;

    public DynamicParameterMap(int id) {
        this.id = id;
        this.mapParameter = new HashMap<>();
        logger.info("Create " + toString());
    }

    @Override
    public void putParameter(String name, String value) {
        logger.debug("putParameter return Name:" + name + " value:" + value);
        mapParameter.put(name, value);
    }

    @Override
    public String getParameter(String name) {
        String value = mapParameter.get(name);
        logger.debug("getParameter return Name:" + name + " value:" + value);
        return value;
    }

    @Override
    public void putParameterInt(String name, int value) throws NumberFormatException {
        putParameter(name, value + "");
    }

    @Override
    public int getParameterInt(String name) throws NumberFormatException {
        int value = Integer.parseInt(mapParameter.get(name));
        logger.debug("getParameterInt return Name:" + name + " value:" + value);
        return value;
    }

    @Override
    public boolean getParameterBoolean(String name) throws NumberFormatException {
        boolean value = Boolean.parseBoolean(mapParameter.get(name));
        logger.debug("getParameterBoolean return Name:" + name + " value:" + value);
        return value;
    }

    @Override
    public void putParameterBoolean(String name, boolean value) throws NumberFormatException {
        putParameter(name, value + "");
    }

    @Override
    public String toString() {
        return "DynamicParameterMap{" +
                "id=" + id +
                ", mapParameter=" + mapParameter +
                '}';
    }
}
