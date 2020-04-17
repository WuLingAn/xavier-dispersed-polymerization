package xavier.Interest.polymerization.builder;

public interface IRule<T> {
    IRuleConfig<T> match(T t);
}
