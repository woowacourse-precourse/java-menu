package menu;

@FunctionalInterface
public interface TryCatchCallback<T> {
    public T run();
}
