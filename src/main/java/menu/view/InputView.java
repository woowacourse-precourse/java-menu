package menu.view;import camp.nextstep.edu.missionutils.Console;public class InputView {    private static final String INPUT_COACH_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";    private static final String INPUT_COACH_FOOD_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";    public String readCoachInput() {        System.out.println(INPUT_COACH_MESSAGE);        return Console.readLine();    }    public String readCoachFoodInput(String name) {        System.out.println(String.format(INPUT_COACH_FOOD_MESSAGE, name));        return Console.readLine();    }}