package xavier.Interest.polymerization.entity;

import xavier.Interest.polymerization.builder.IRuleConfig;

import java.math.BigDecimal;

public class RuleConfig extends IRuleConfig<DisperseData> {
    private BigDecimal upLimit;
    private BigDecimal lowLimit;
    private OverType overType;

    /**
     * x > lowLimit && x <= upLimit
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

    /**
     * lowLimit < x <= upLimit
     *
     * @param data
     * @return
     */
    @Override
    public boolean match(DisperseData data) {
        BigDecimal value = data.getDataValue();
        if (upLimit == null && lowLimit == null) {
            throw new IllegalArgumentException("无效的上下限设置");
        }
        // 没有上界
        if (upLimit == null) {
            return value.compareTo(lowLimit) > 0;
        }
        // 没有下界
        if (lowLimit == null) {
            return value.compareTo(upLimit) <= 0;
        }
        // lowLimit < x <= upLimit
        return value.compareTo(upLimit) <= 0 && value.compareTo(lowLimit) > 0;
    }

    public OverType matchType(DisperseData data) {
        return match(data) ? this.overType : OverType.NORMAL;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof RuleConfig) {
            RuleConfig rc = ((RuleConfig) o);
            if (rc.getLowLimit() == null)
                return -1;
            if (rc.getUpLimit() == null)
                return 1;
            return this.getLowLimit().compareTo(rc.getLowLimit());
        }
        return -1;
    }

    @Override
    public String toString() {
        return "RuleConfig{" +
                "upLimit=" + upLimit +
                ", lowLimit=" + lowLimit +
                ", overType=" + overType +
                '}';
    }

}
