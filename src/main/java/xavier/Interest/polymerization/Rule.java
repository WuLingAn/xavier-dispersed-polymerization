package xavier.Interest.polymerization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xavier.Interest.polymerization.builder.IRule;
import xavier.Interest.polymerization.builder.IRuleConfig;
import xavier.Interest.polymerization.entity.DisperseData;
import xavier.Interest.polymerization.entity.RuleConfig;

import java.util.*;

public class Rule implements IRule<DisperseData> {
    private static final Logger logger = LoggerFactory.getLogger(Rule.class);

    private List<RuleConfig> ruleConfigs = new ArrayList<>();
    // 默认排序规则，以下限逆序排序
    private Comparator<RuleConfig> configOrderComparator = (rc1, rc2) -> {
        if (rc1.getLowLimit() == null)
            return -1;
        if (rc2.getUpLimit() == null)
            return 1;
        return rc2.getLowLimit().compareTo(rc1.getLowLimit());
    };

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

    /**
     * 对配置规则排序
     *
     * @return
     */
    public Rule orderRuleConfig() {
        if (!hasOrder && configOrderComparator != null) {
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
    public void setConfigOrderComparator(Comparator<RuleConfig> configOrderComparator) {
        if (configOrderComparator == null) {
            throw new NullPointerException("设置的排序规则为NULL");
        }
        if (this.configOrderComparator != configOrderComparator) {
            this.configOrderComparator = configOrderComparator;
            hasOrder = false;
        }
    }

    /**
     * 关闭互斥
     *
     * @return
     */
    public Rule closeExclude() {
        isExclude = false;
        logger.debug("确认关闭互斥设置");
        return this;
    }

    public boolean isExclude() {
        return isExclude;
    }

    public Rule setExclude(boolean exclude) {
        if (isExclude != exclude) {
            if (!exclude) {
                closeExclude();
            } else {
                isExclude = true;
            }
        }
        return this;
    }

    @Override
    public IRuleConfig match(DisperseData disperseData) {
        //for ()
        return null;
    }
}
