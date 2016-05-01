package com.GameEngine.logic.dynamicValues;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

/**
 * Реализация DynamicParameter через HashMap.
 */
public class DynamicParameterMap implements DynamicParameter {
    private HashMap<String, String> mapParameter;
    private static final Logger logger = LogManager.getLogger(DynamicParameterMap.class);

    public DynamicParameterMap() {
        this.mapParameter = new HashMap<>();
        logger.info("Create.");
    }

    @Override
    public void putParameter(String name, String value) {
        logger.debug("New param Name:" + name + " value:" + value);
        mapParameter.put(name, value);
    }

    @Override
    public void putParameterInt(String name, int value) {
        logger.debug("New param Name:" + name + " value:" + value);
        putParameter(name, value + "");
    }

    @Override
    public String getParameter(String name) {
        String value = mapParameter.get(name);
        logger.debug("Get param Name:" + name + " value:" + value);
        return value;
    }

    @Override
    public int getParameterInt(String name) {
        int value = Integer.parseInt(getParameter(name));
        logger.debug("Get param Name:" + name + " value:" + value);
        return value;
    }
}
