package menu.config;

import java.lang.reflect.Proxy;
import menu.domain.NumberGenerator;
import menu.domain.MenuApplication;
import menu.domain.RandomNumberGenerator;
import menu.domain.RecommendCategoryMaker;
import menu.handler.ExceptionHandler;
import menu.view.InputView;
import menu.view.InputViewImpl;
import menu.view.OutputView;

public class MenuApplicationFactory {

    public MenuApplicationFactory() {
    }

    public MenuApplication generateApp() {
        return new MenuApplication(initInputView(), initOutputView(), initRecommendCategoryMaker());
    }

    private InputView initInputView() {
        InputView inputView = new InputViewImpl();
        InputView inputViewProxy = (InputView) Proxy.newProxyInstance(InputView.class.getClassLoader(),
                new Class[]{InputView.class},
                new ExceptionHandler(inputView));
        return inputViewProxy;
    }

    private OutputView initOutputView() {
        return new OutputView();
    }

    private RecommendCategoryMaker initRecommendCategoryMaker() {
        return new RecommendCategoryMaker(initNumberGenerator());
    }

    private NumberGenerator initNumberGenerator() {
        return new RandomNumberGenerator();
    }
}
