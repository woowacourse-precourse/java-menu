package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.EnumMap;
import java.util.Map;

public class ControllerFactory {
    private static final Map<ControllerType, Controllable> controllers = new EnumMap<>(ControllerType.class);
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    static {
        controllers.put(ControllerType.MAIN, toErrorCheckController(new MainController(outputView)));
        controllers.put(ControllerType.INPUT_MEMBER, toErrorCheckController(new InputMemberController(inputView, outputView)));
        controllers.put(ControllerType.INPUT_CANT_EAT, toErrorCheckController(new InputCantEatController(inputView, outputView)));
        controllers.put(ControllerType.RECOMMEND_RESULT, toErrorCheckController(new RecommendResultController(outputView)));
        controllers.put(ControllerType.EXIT, toErrorCheckController(new ExitController(outputView)));
    }

    public static Controllable get(ControllerType type) {
        return controllers.get(type);
    }

    private static Controllable toErrorCheckController(Controllable controllable) {
        return new ErrorCheckController(controllable);
    }
}