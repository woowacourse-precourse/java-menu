package menu.domain.menu.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.common.input.InputContext;
import menu.common.operate.OperateContext;
import menu.config.MenuInformation;
import menu.domain.menu.dto.InputValidationRequest;
import menu.domain.menu.dto.InputValidationResponse;
import menu.domain.menu.dto.MenuRecommendResponse;
import menu.domain.menu.model.Coach;
import menu.domain.menu.model.Food;
import menu.domain.menu.repository.FoodRepository;
import menu.domain.menu.service.MenuRecommendService;
import menu.domain.menu.type.ValidationType;
import menu.domain.menu.validation.InputValidationChain;
import menu.domain.menu.view.InputView;
import menu.domain.menu.view.OutputView;

public class MenuController {

    private final MenuRecommendService menuRecommendService;
    private final FoodRepository foodRepository;
    private final InputValidationChain validator;
    private final InputContext inputContext;
    private final OperateContext operateContext;
    private static final String FOOD_NOT_FOUND_EXCEPTION_MESSAGE = "해당 음식이 존재하지 않습니다.";

    public MenuController(MenuRecommendService menuRecommendService, FoodRepository foodRepository,
        InputValidationChain validator, InputContext inputContext, OperateContext operateContext) {
        this.menuRecommendService = menuRecommendService;
        this.foodRepository = foodRepository;
        this.validator = validator;
        this.inputContext = inputContext;
        this.operateContext = operateContext;
    }

    public void run() {
        OutputView.printStartComment();
        List<Coach> coaches = operateContext.workWithOptionStrategy(this::getCoaches);
        List<MenuRecommendResponse> recommendResponses = menuRecommendService.menuRecommend(coaches);
        OutputView.printRecommendResult(recommendResponses);
        OutputView.printEndComment();
    }

    private List<Coach> getCoaches() {
        List<Coach> coaches = mapToCoach(getCoachNames());
        for (Coach coach : coaches) {
            operateContext.workWithOptionStrategy(() -> setForbiddenFood(coach));
        }
        return coaches;
    }

    private boolean setForbiddenFood(Coach coach) {
        String[] foodNames = getForbiddenFoodNames(coach.getName()).split(MenuInformation.INPUT_DIVIDE_POINT);
        if (foodNames.length == 1 && foodNames[0].equals("")) {
            return true;
        }
        addForbiddenFood(coach, foodNames);
        return true;
    }

    private void addForbiddenFood(Coach coach, String[] foodNames) {
        for (String foodName : foodNames) {
            Food food = foodRepository.findByName(foodName);
            if (food == null) {
                throw new IllegalArgumentException(FOOD_NOT_FOUND_EXCEPTION_MESSAGE);
            }
            coach.getForbiddenFood().add(food);
        }
    }

    private List<Coach> mapToCoach(String names) {
        return Arrays.stream(names.split(MenuInformation.INPUT_DIVIDE_POINT)).map(Coach::new)
            .collect(Collectors.toList());
    }

    private String getCoachNames() {
        return inputContext.workWithInputStrategy(validator, validator -> {
            String input = InputView.inputCoaches();
            List<ValidationType> validationTypes = List.of(ValidationType.COACH_NAME, ValidationType.NULL_OR_BLANK);
            return validateRequest(validator, new InputValidationRequest(validationTypes, input));
        });
    }

    private String getForbiddenFoodNames(String name) {
        return inputContext.workWithInputStrategy(validator, validator -> {
            String input = InputView.inputForbiddenFoods(name);
            List<ValidationType> validationTypes = List.of(ValidationType.FORBIDDEN_FOOD);
            return validateRequest(validator, new InputValidationRequest(validationTypes, input));
        });
    }

    private String validateRequest(InputValidationChain validator, InputValidationRequest request) {
        InputValidationResponse response = validator.validate(request);
        if (!response.isValid()) {
            throw new IllegalArgumentException(response.getMessage());
        }
        return request.getTarget();
    }
}
