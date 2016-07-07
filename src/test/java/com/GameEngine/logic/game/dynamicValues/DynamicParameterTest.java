package com.GameEngine.logic.game.dynamicValues;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Тест для интерфейса DynamicParameter.
 * По умолчанию тестирует только DynamicParameterMap.
 * Но любой класс реализующий DynamicParameter может пройти данный тест.
 * Для этого нужно вызвать метод createData() передать в него DynamicParameter.
 */
@RunWith(Parameterized.class)
public class DynamicParameterTest {
    private static final Logger LOGGER = LogManager.getLogger(DynamicParameterTest.class);
    /**
     * Содержит Parameterized данные для тестирования.
     */
    private static ArrayList<Object[]> listParametersDate = new ArrayList<>();
    /**
     * Тестируемый DynamicParameter.
     */
    @Parameterized.Parameter
    public DynamicParameter dynamicParameter;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        if (listParametersDate.size() == 0) {
            createData(DynamicParameterMapTest.getDynamicParameter());
        }
        return listParametersDate;
    }

    /**
     * Создаёт данные для тестирования класса и помешает их в dynamicParameters.
     *
     * @param dynamicParameters массив DynamicParameter которых нужно протестировать.
     */
    public static void createData(final DynamicParameter... dynamicParameters) {
        for (DynamicParameter dynamicParameter : dynamicParameters) {
            addDynamicParameter(dynamicParameter);
        }
    }

    /**
     * Добавляет Object[] с данными в dynamicParameters.
     *
     * @param dynamicParameter DynamicParameter который будет передан в Object[].
     */
    private static void addDynamicParameter(DynamicParameter dynamicParameter) {
        LOGGER.debug("Add new DynamicParameter = " + dynamicParameter.getClass());
        listParametersDate.add(new Object[]{dynamicParameter});
    }

    @Before
    public void setUp() throws Exception {
        LOGGER.debug("Testing DynamicParameter = " + dynamicParameter.getClass());
    }

    @Test
    public void putAndGetParameter() throws Exception {
        String param = "param1";
        String value = "value1";
        dynamicParameter.putParameter(param, value);
        assertEquals(dynamicParameter.getParameter(param), value);
    }

    @Test
    public void putAndGetParameterNull() throws Exception {
        assertNull(dynamicParameter.getParameter("NullParam"));
    }

    @Test
    public void putAndGetParameterInt() throws Exception {
        String param = "param1";
        int value = 29;
        dynamicParameter.putParameterInt(param, value);
        assertTrue(dynamicParameter.getParameterInt(param) == value);
    }

    @Test(expected = NumberFormatException.class)
    public void putAndGetParameterIntException() throws Exception {
        dynamicParameter.getParameterInt("NullParam");
    }


    @Test
    public void patAndGetParameterBoolean() throws Exception {
        String param = "param1";
        Boolean value = false;
        dynamicParameter.putParameterBoolean(param, value);
        assertTrue(dynamicParameter.getParameterBoolean(param) == value);
    }

    @Test
    public void putAndGetParameterBooleanNull() throws Exception {
        assertFalse(dynamicParameter.getParameterBoolean("NullParam"));
    }

    /**
     * После завершения обнуляет listParametersDate.
     */
    @After
    public void tearDown() {
        listParametersDate.clear();
    }
}