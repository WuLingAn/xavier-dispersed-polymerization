package xavier.Interest.polymerization.builder;


public interface IDefaultPolymerizationBuilder<T, V> {

    /**
     * 初始化汇总数据对象
     */
    T createData(V data);

    /**
     * 更新汇总数据对象
     *
     * @return
     */
    T updateDate(T p, V d);

    /**
     * 结束本次汇总
     */
    T closeDate(T t, V date);

}
