package xavier.Interest.polymerization.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xavier.Interest.polymerization.basic.DataUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 离散数据对象，基本属性，数据值，数据时间
 */
public class DisperseData {
    private static final Logger logger = LoggerFactory.getLogger(DisperseData.class);

    private BigDecimal dataValue;
    private LocalDateTime dataDate;

    public DisperseData() {

    }

    public DisperseData(Number value, LocalDateTime dataDate) {
        this.dataDate = dataDate;
        setDataValue(value);
    }

    public DisperseData(BigDecimal dataValue, LocalDateTime dataDate) {
        this.dataValue = dataValue;
        this.dataDate = dataDate;
    }

    public BigDecimal getDataValue() {
        return dataValue;
    }

    /**
     * 以Number为属性值赋值
     *
     * @param number
     */
    public void setDataValue(Number number) {
        setDataValue(DataUtil.numberValueToString(number));
    }

    /**
     * 属性值赋值，不合法字面量赋值为 BigDecimal.ZERO
     *
     * @param value 数值字面量
     */
    public void setDataValue(String value) {
        try {
            this.dataValue = new BigDecimal(value);
        } catch (Exception e){
            logger.debug("非法的数值赋值【{1}】",value);
            this.dataValue = BigDecimal.ZERO;
        }
    }

    public void setDataValue(BigDecimal dataValue) {
        this.dataValue = dataValue;
    }

    public LocalDateTime getDataDate() {
        return dataDate;
    }

    public void setDataDate(LocalDateTime dataDate) {
        this.dataDate = dataDate;
    }
}
