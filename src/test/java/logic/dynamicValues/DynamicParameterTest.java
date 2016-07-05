package logic.dynamicValues;

import com.GameEngine.logic.game.dynamicValues.DynamicParameter;
import com.GameEngine.logic.game.dynamicValues.DynamicParameterMap;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;
import java.util.Random;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Тест класса DynamicParameter
 */
public class DynamicParameterTest {

    private DynamicParameter dParam = new DynamicParameterMap(1);


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void putAndGetParameter() throws Exception {

        String param1 = getRandomParam();
        String param2 = getRandomParam();
        String param3 = getRandomParam();
        String param4 = getRandomParam();
        String param5 = getRandomParam();

        dParam.putParameter("param1", param1);
        dParam.putParameter("param2", param2);
        dParam.putParameter("param3", param3);
        dParam.putParameter("param4", param4);
        dParam.putParameter("param5", param5);

        assertTrue(Objects.equals(dParam.getParameter("param1"), param1));
        assertTrue(Objects.equals(dParam.getParameter("param2"), param2));
        assertTrue(Objects.equals(dParam.getParameter("param3"), param3));
        assertTrue(Objects.equals(dParam.getParameter("param4"), param4));
        assertTrue(Objects.equals(dParam.getParameter("param5"), param5));
        assertNull(dParam.getParameter("falseParam"));

    }

    @Test
    public void putAndGetParameterInt() throws Exception {
        int param1 = getRandomParamInt();
        int param2 = getRandomParamInt();
        int param3 = getRandomParamInt();
        int param4 = getRandomParamInt();
        int param5 = getRandomParamInt();

        dParam.putParameterInt("param1", param1);
        dParam.putParameterInt("param2", param2);
        dParam.putParameterInt("param3", param3);
        dParam.putParameterInt("param4", param4);
        dParam.putParameterInt("param5", param5);

        assertTrue(dParam.getParameterInt("param1") == param1);
        assertTrue(dParam.getParameterInt("param2") == param2);
        assertTrue(dParam.getParameterInt("param3") == param3);
        assertTrue(dParam.getParameterInt("param4") == param4);
        assertTrue(dParam.getParameterInt("param5") == param5);
    }

    @Test(expected = NumberFormatException.class)
    public void putAndGetParameterIntException() throws Exception {
        dParam.getParameterInt("falseParam");
    }

    private String getRandomParam() {
        return new Random().nextInt(1000) + "";
    }

    private int getRandomParamInt() {
        return new Random().nextInt(1000);
    }

}