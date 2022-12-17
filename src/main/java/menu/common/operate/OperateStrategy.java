package menu.common.operate;

public interface OperateStrategy<T> {

    T executeOption() throws IllegalArgumentException;
}
