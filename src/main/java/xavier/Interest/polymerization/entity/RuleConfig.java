package xavier.Interest.polymerization.entity;

import java.math.BigDecimal;

public class RuleConfig {
    private BigDecimal upLimit;
    private BigDecimal lowLimit;
    private OverType overType;

    /**
     * x >= lowLimit && x <= upLimit
     *
     * @param upLimit
     * @param lowLimit
     * @param overType
     */
    public RuleConfig(BigDecimal upLimit, BigDecimal lowLimit, OverType overType) {
        this.upLimit = upLimit;
        this.lowLimit = lowLimit;
        this.overType = overType;
    }

    public BigDecimal getUpLimit() {
        return upLimit;
    }

    public void setUpLimit(BigDecimal upLimit) {
        this.upLimit = upLimit;
    }

    public BigDecimal getLowLimit() {
        return lowLimit;
    }

    public void setLowLimit(BigDecimal lowLimit) {
        this.lowLimit = lowLimit;
    }

    public OverType getOverType() {
        return overType;
    }

    public void setOverType(OverType overType) {
        this.overType = overType;
    }

    @Override
    public String toString() {
        return "RuleConfig{}";
    }
}
