package xavier.Interest.polymerization.builder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import xavier.Interest.polymerization.DefaultPolymerizationBuilder;
import xavier.Interest.polymerization.Handler;
import xavier.Interest.polymerization.Rule;
import xavier.Interest.polymerization.Tools;
import xavier.Interest.polymerization.entity.DisperseData;
import xavier.Interest.polymerization.entity.PolymerizationData;
import xavier.Interest.polymerization.entity.PolymerizationType;
import xavier.Interest.polymerization.entity.RuleConfig;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
            PolymerizationData polymerizationData = builder.createData(disperseDataList.get(0),null);

            assertEquals(dataValue, polymerizationData.getMaxValue());
            assertEquals(dataValue, polymerizationData.getMinValue());
            assertTrue(polymerizationData.getSumNegativeValue().compareTo(BigDecimal.ZERO) == 0);
            assertEquals(dataValue, polymerizationData.getSumPositiveValue());
            assertEquals(dataValue, polymerizationData.getSumValue());
            assertEquals(disperseData.getDataDate(), polymerizationData.getStartTime());
            assertEquals(dataValue, polymerizationData.getStartValue());
            assertEquals(null, polymerizationData.getEndTime());
            assertEquals(null, polymerizationData.getEndValue());
        }

        @Test
        @DisplayName("流程测试")
        public void testExce() {
            Rule rule = new Rule();
            rule.addRuleConfig(
                    new RuleConfig(10, 0, PolymerizationType.DEFAULT_TYPES.get(0)),
                    new RuleConfig(20, 10, PolymerizationType.DEFAULT_TYPES.get(0))/*,
                    new RuleConfig(25, 20, PolymerizationType.DEFAULT_TYPES.get(0)),
                    new RuleConfig(50, 25, PolymerizationType.DEFAULT_TYPES.get(0)),
                    new RuleConfig(70, 50, PolymerizationType.DEFAULT_TYPES.get(0)),
                    new RuleConfig(100, 70, PolymerizationType.DEFAULT_TYPES.get(0))*/
            );

            Handler handler = Handler.getInstance(rule);

            List<PolymerizationData> execute = handler.execute(Tools.generateData(0.0,2.0,10));

            System.out.println(execute);
        }

    }

}
