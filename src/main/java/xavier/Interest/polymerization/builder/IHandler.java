package xavier.Interest.polymerization.builder;

import java.util.List;

public interface IHandler<T, V> {
    List<T> execute(List<V> values);

    IRuleConfig<V> match(V v);
}
