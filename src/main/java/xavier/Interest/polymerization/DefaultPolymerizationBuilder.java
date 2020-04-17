package xavier.Interest.polymerization;

import xavier.Interest.polymerization.builder.IDefaultPolymerizationBuilder;
import xavier.Interest.polymerization.entity.DisperseData;
import xavier.Interest.polymerization.entity.PolymerizationData;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 默认的汇总构建工具
 */
public class DefaultPolymerizationBuilder
        implements IDefaultPolymerizationBuilder<PolymerizationData, DisperseData> {

    private DefaultPolymerizationBuilder() {

    }

    public static DefaultPolymerizationBuilder getInstance(DisperseData disperseData) {
        DefaultPolymerizationBuilder builder = new DefaultPolymerizationBuilder();
        builder.createData(disperseData);
        return builder;
    }

    public static DefaultPolymerizationBuilder getInstance() {
        DefaultPolymerizationBuilder builder = new DefaultPolymerizationBuilder();
        return builder;
    }

    public PolymerizationData createData(DisperseData disperseData) {
        PolymerizationData polymerizationData = new PolymerizationData();

        polymerizationData.setStartTime(disperseData.getDataDate());
        polymerizationData.setStartValue(disperseData.getDataValue());

        addSumValue(polymerizationData, disperseData.getDataValue());
        updateExtremum(polymerizationData, disperseData.getDataValue(), disperseData.getDataDate());
        return polymerizationData;
    }

    /**
     * 更新数值
     *
     * @param date
     * @return
     */
    public PolymerizationData updateDate(PolymerizationData polymerizationData, DisperseData date) {
        updateExtremum(polymerizationData, date.getDataValue(), date.getDataDate());
        return polymerizationData;
    }


    public PolymerizationData closeDate(PolymerizationData polymerizationData, DisperseData date) {
        updateDate(polymerizationData, date);
        polymerizationData.setEndValue(date.getDataValue());
        polymerizationData.setEndTime(date.getDataDate());
        return polymerizationData;
    }

    /**
     * 更新最大值、最大值时间/最小值、最小值时间
     *
     * @param newValue
     * @param newDate
     */
    public void updateExtremum(PolymerizationData polymerizationData, BigDecimal newValue, LocalDateTime newDate) {
        // 最大小于新的值
        if (polymerizationData.getMaxValue() == null || polymerizationData.getMaxValue().compareTo(newValue) < 0) {
            polymerizationData.setMaxValue(newValue);
            polymerizationData.setMaxValueDate(newDate);
        }
        // 最小大于新的值
        if (polymerizationData.getMinValue() == null || polymerizationData.getMinValue().compareTo(newValue) > 0) {
            polymerizationData.setMinValue(newValue);
            polymerizationData.setMinValueDate(newDate);
        }
    }

    /**
     * 汇总计算和值、正和值、负和值
     *
     * @param value 新的项目值
     */
    public void addSumValue(PolymerizationData polymerizationData, BigDecimal value) {
        BigDecimal sumValue = polymerizationData.getSumValue();
        polymerizationData.setSumValue(sumValue.add(value));
        // 大于0
        if (value.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal sumPositiveValue = polymerizationData.getSumPositiveValue();
            polymerizationData.setSumPositiveValue(sumPositiveValue.add(value));
        } else {
            // 小于0
            BigDecimal sumNegativeValue = polymerizationData.getSumNegativeValue();
            polymerizationData.setSumNegativeValue(sumNegativeValue.add(value));
        }
    }
}
