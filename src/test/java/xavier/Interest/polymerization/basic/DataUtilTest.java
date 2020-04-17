package xavier.Interest.polymerization.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DataUtilTest {
    @Test
    @DisplayName("测试Number转文本-入参为null")
    public void testNumberValueToStringWithNull(){
        Assertions.assertEquals(null,DataUtil.numberValueToString(null));
    }

    @Test
    @DisplayName("测试Number转文本-入参为Double")
    public void testDoubleValueToString(){
        Assertions.assertEquals("12.5",DataUtil.numberValueToString(12.5));
    }

    @Test
    @DisplayName("测试Number转文本-入参为Integer")
    public void testIntegerToString(){
        Assertions.assertEquals("12",DataUtil.numberValueToString(12));
    }

    @Test
    @DisplayName("测试Number转文本-入参为Integer")
    public void testIntegerToStringWithDefault(){
        Assertions.assertEquals("13",DataUtil.numberValueToString(null,"13"));
    }
}
