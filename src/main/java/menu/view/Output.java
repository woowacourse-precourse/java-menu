package menu.view;

import menu.dto.CompleteMenuDto;
import menu.dto.ResultDto;

import java.util.List;

public class Output {

    private static final String START_GUIDE_MESSAGE = "점심 메뉴 추천을 시작합니다.";

    private static final String COACH_NAME_INPUT_GUIDE_MESSAGE = "코치의 이름을 입력해주세요. (, 로 구분)";

    private static final String HATING_MENUS_INPUT_GUIDE_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String RESULT_GUIDE_MESSAGE = "메뉴 추천 결과입니다.";

    private static final String TABLE_HEAD_CONTENT = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";

    private static final String RESULT_COMPLETE_MESSAGE = "추천을 완료했습니다.";
    private static final String ERROR = "[ERROR] ";
    public void printStartMessage() {
        System.out.println(START_GUIDE_MESSAGE);
        System.out.println();
    }

    public void printCoachNamesMessage() {
        System.out.println(COACH_NAME_INPUT_GUIDE_MESSAGE);
    }

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(ERROR + e.getMessage());
        System.out.println();
    }

    public void printHatingMenusMessage(String coachName) {
        System.out.println(coachName + HATING_MENUS_INPUT_GUIDE_MESSAGE);
    }

    public void printResultGuideMessage() {
        System.out.println(RESULT_GUIDE_MESSAGE);
    }

    public void printResult(ResultDto resultDto) {
        printTableHead();
        printCategories(resultDto.getCategories());
        printMenus(resultDto.getCompleteMenuDtos());
        System.out.println();
    }

    private void printMenus(List<CompleteMenuDto> completeMenuDtos) {
        for (CompleteMenuDto completeMenuDto : completeMenuDtos) {
            printEachMenu(completeMenuDto);
        }
    }

    private void printEachMenu(CompleteMenuDto completeMenuDto) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ " + completeMenuDto.getName() + " ");
        for (String completeMenu : completeMenuDto.getCompleteMenus()) {
            sb.append("| " + completeMenu + " ");
        }
        sb.append("]");
        System.out.println(sb);
    }

    private void printCategories(List<String> categories) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ 카테고리 ");
        for (String category : categories) {
            sb.append("| " + category + " ");
        }
        sb.append("]");
        System.out.println(sb);
    }

    private void printTableHead() {
        System.out.println(TABLE_HEAD_CONTENT);
    }

    public void printResultCompleteMessage() {
        System.out.println(RESULT_COMPLETE_MESSAGE);
    }
}
