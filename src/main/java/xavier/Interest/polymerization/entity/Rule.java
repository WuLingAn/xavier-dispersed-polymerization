package xavier.Interest.polymerization.entity;

import java.util.*;

public class Rule {

    private List<RuleConfig> ruleConfigs = new ArrayList<>();
    // 默认排序规则，以下限逆序排序
    private Comparator configOrderComparator = (Comparator<RuleConfig>) (rc1, rc2) -> rc2.getLowLimit().compareTo(rc1.getLowLimit());

    // 是否开启规则配置互斥
    private boolean isExclude = true;
    // 是否排序完成
    private boolean hasOrder;

    public Rule(List<RuleConfig> ruleConfigs) {
        this.ruleConfigs = ruleConfigs;
    }

    public Rule() {
    }

    /**
     * 新增规则配置，并排序。排序需要设置排序规则
     *
     * @param newRuleConfigs
     */
    public void addRuleConfig(RuleConfig... newRuleConfigs) {
        this.ruleConfigs.addAll(Arrays.asList(newRuleConfigs));
        orderRuleConfig();
    }

    //排序
    public Rule orderRuleConfig() {
        if (configOrderComparator != null) {
            Collections.sort(ruleConfigs, configOrderComparator);
            hasOrder = true;
        }
        return this;
    }

    /**
     * 添加自定义排序规则
     *
     * @param configOrderComparator
     */
    public void setConfigOrderComparator(Comparator configOrderComparator) {
        this.configOrderComparator = configOrderComparator;
    }

    public Rule setExclude(boolean exclude) {
        isExclude = exclude;
        return this;
    }

    public Rule closeExclude() {
        isExclude = false;
        return this;
    }
}
