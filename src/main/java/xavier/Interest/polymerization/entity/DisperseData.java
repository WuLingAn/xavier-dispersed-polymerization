package xavier.Interest.polymerization.entity;

import org.apache.commons.lang3.StringUtils;
import xavier.Interest.polymerization.basic.DataUtil;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 离散数据对象，基本属性，数据值，数据时间
 */
public class DisperseData {
    private BigDecimal dataValue;
    private Date dataDate;

    public DisperseData() {
    }

    public DisperseData(Number value, Date dataDate) {
        this.dataDate = dataDate;
        setDataValue(value);
    }

    public DisperseData(BigDecimal dataValue, Date dataDate) {
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
        if (StringUtils.isNumeric(value)) {
            this.dataValue = new BigDecimal(value);
        } else {
            this.dataValue = BigDecimal.ZERO;
        }
    }

    public void setDataValue(BigDecimal dataValue) {
        this.dataValue = dataValue;
    }

    public Date getDataDate() {
        return dataDate;
    }

    public void setDataDate(Date dataDate) {
        this.dataDate = dataDate;
    }
}
