package xavier.Interest.polymerization.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import xavier.Interest.polymerization.Tools;
import xavier.Interest.polymerization.entity.DisperseData;
import xavier.Interest.polymerization.entity.PolymerizationData;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DefaultPolymerizationBuilderTest {

    private static List<DisperseData> disperseDataList;

    @BeforeAll
    @DisplayName("初始化测试用数据")
    private static void initAll(){
        disperseDataList = new ArrayList<>();
        disperseDataList.add(new DisperseData(12.5, Tools.strToLocalDate("2020-04-12 12:00:01")));
    }


    @Nested
    @DisplayName("流程测试")
    class WhenNew {

        @Test
        @DisplayName("测试初始化")
        public void testCreateData(){
            DefaultPolymerizationBuilder builder = DefaultPolymerizationBuilder.getInstance();
            DisperseData disperseData = disperseDataList.get(0);
            BigDecimal dataValue = disperseData.getDataValue();
            PolymerizationData polymerizationData = builder.createData(disperseDataList.get(0));

            assertEquals(dataValue,polymerizationData.getMaxValue());
            assertEquals(dataValue,polymerizationData.getMinValue());
            assertTrue(polymerizationData.getSumNegativeValue().compareTo(BigDecimal.ZERO)==0);
            assertEquals(dataValue,polymerizationData.getSumPositiveValue());
            assertEquals(dataValue,polymerizationData.getSumValue());
            assertEquals(disperseData.getDataDate(),polymerizationData.getStartTime());
            assertEquals(dataValue,polymerizationData.getStartValue());
            assertEquals(null,polymerizationData.getEndTime());
            assertEquals(null,polymerizationData.getEndValue());
        }

    }

}
