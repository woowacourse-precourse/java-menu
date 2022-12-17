package menu.common.operate;

import menu.common.exception.ErrorInformation;

public class OperateContext {
    
    public <T> T workWithOptionStrategy(OperateStrategy<T> operateStrategy) {
        T result = null;
        while (result == null) {
            try {
                result = operateStrategy.executeOption();
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorInformation.ERROR_PREFIX + e.getMessage());
            }
        }
        return result;
    }
}
