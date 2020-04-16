package xavier.Interest.polymerization.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 汇总类
 */
public class PolymerizationData {
    private OverType message;
    // 开始时间
    private Date startTime;
    // 结束时间
    private Date endTime;
    // 最大值
    private BigDecimal maxValue;
    // 最大值时间
    private Date maxValueDate;
    // 最小值
    private BigDecimal minValue;
    // 最小值时间
    private Date minValueDate;
    // 开始值
    private BigDecimal startValue;
    // 结束值
    private BigDecimal endValue;
    // 求和
    private BigDecimal sumValue = new BigDecimal(0);
    // 正数求和
    private BigDecimal sumPositiveValue = new BigDecimal(0);
    // 负数求和
    private BigDecimal sumNegativeValue = new BigDecimal(0);

    public OverType getMessage() {
        return message;
    }

    public void setMessage(OverType message) {
        this.message = message;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(BigDecimal maxValue) {
        this.maxValue = maxValue;
    }

    public BigDecimal getMinValue() {
        return minValue;
    }

    public void setMinValue(BigDecimal minValue) {
        this.minValue = minValue;
    }

    public BigDecimal getStartValue() {
        return startValue;
    }

    public void setStartValue(BigDecimal startValue) {
        this.startValue = startValue;
    }

    public BigDecimal getEndValue() {
        return endValue;
    }

    public void setEndValue(BigDecimal endValue) {
        this.endValue = endValue;
    }

    public BigDecimal getSumValue() {
        return sumValue;
    }

    public void setSumValue(BigDecimal sumValue) {
        this.sumValue = sumValue;
    }

    public BigDecimal getSumPositiveValue() {
        return sumPositiveValue;
    }

    public void setSumPositiveValue(BigDecimal sumPositiveValue) {
        this.sumPositiveValue = sumPositiveValue;
    }

    public BigDecimal getSumNegativeValue() {
        return sumNegativeValue;
    }

    public void setSumNegativeValue(BigDecimal sumNegativeValue) {
        this.sumNegativeValue = sumNegativeValue;
    }

    public Date getMaxValueDate() {
        return maxValueDate;
    }

    public void setMaxValueDate(Date maxValueDate) {
        this.maxValueDate = maxValueDate;
    }

    public Date getMinValueDate() {
        return minValueDate;
    }

    public void setMinValueDate(Date minValueDate) {
        this.minValueDate = minValueDate;
    }
}
