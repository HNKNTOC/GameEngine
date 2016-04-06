package logic.dynamicValues;

import com.GameEngine.logic.dynamicValues.DynamicParameter;
import com.GameEngine.logic.dynamicValues.DynamicParameterMap;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;
import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Created by Nikita on 05.04.2016.
 */
public class DynamicParameterTest {

    private DynamicParameter<String, String> dParam = new DynamicParameterMap();

    private String param1 = getRandomParam();
    private String param2 = getRandomParam();
    private String param3 = getRandomParam();
    private String param4 = getRandomParam();
    private String param5 = getRandomParam();


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void putAndGetParameter() throws Exception {
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
        assertTrue(dParam.getParameter("falseParam") == null);

    }

    private String getRandomParam() {
        return new Random().nextInt(1000) + "";
    }

}