package xavier.Interest.polymerization.builder;

public abstract class IRuleConfig<T> implements Comparable {

    private Integer order;

    public IRuleConfig() {

    }

    public IRuleConfig(Integer order) {
        this.order = order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * 数据规则匹配
     *
     * @param data
     * @return
     */
    public abstract boolean match(T data);

    @Override
    public int compareTo(Object o) {
        if (o instanceof IRuleConfig) {
            return order.compareTo(((IRuleConfig) o).order);
        } else {
            return 0;
        }
    }
}
