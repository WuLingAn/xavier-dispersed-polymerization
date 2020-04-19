package xavier.Interest.polymerization.entity;

import xavier.Interest.polymerization.builder.IPolymerizationType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 汇总类
 */
public class PolymerizationData {
    private IPolymerizationType type;
    // 开始时间
    private LocalDateTime startTime;
    // 结束时间
    private LocalDateTime endTime;
    // 最大值
    private BigDecimal maxValue;
    // 最大值时间
    private LocalDateTime maxValueDate;
    // 最小值
    private BigDecimal minValue;
    // 最小值时间
    private LocalDateTime minValueDate;
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

    public IPolymerizationType getType() {
        return type;
    }

    public void setType(IPolymerizationType type) {
        this.type = type;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
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

    public LocalDateTime getMaxValueDate() {
        return maxValueDate;
    }

    public void setMaxValueDate(LocalDateTime maxValueDate) {
        this.maxValueDate = maxValueDate;
    }

    public LocalDateTime getMinValueDate() {
        return minValueDate;
    }

    public void setMinValueDate(LocalDateTime minValueDate) {
        this.minValueDate = minValueDate;
    }

    @Override
    public String toString() {
        return "PolymerizationData{" +
                "PolymerizationType=" + type +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", maxValue=" + maxValue +
                ", maxValueDate=" + maxValueDate +
                ", minValue=" + minValue +
                ", minValueDate=" + minValueDate +
                ", startValue=" + startValue +
                ", endValue=" + endValue +
                ", sumValue=" + sumValue +
                ", sumPositiveValue=" + sumPositiveValue +
                ", sumNegativeValue=" + sumNegativeValue +
                '}';
    }
}
