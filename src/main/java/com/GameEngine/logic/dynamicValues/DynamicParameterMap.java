package com.GameEngine.logic.dynamicValues;

import java.util.HashMap;

/**
 * Реализация DynamicParameter через HashMap.
 */
public class DynamicParameterMap implements DynamicParameter<String, String> {
    private HashMap<String, String> mapParameter;

    public DynamicParameterMap() {
        this.mapParameter = new HashMap<>();
    }

    @Override
    public void putParameter(String name, String value) {
        mapParameter.put(name, value);
    }

    @Override
    public String getParameter(String name) {
        return mapParameter.get(name);
    }
}
