package menu.view;

import static java.text.MessageFormat.format;

import java.util.List;
import java.util.stream.Collectors;
import menu.dto.MenuDto;
import menu.dto.MenusDto;

public class OutputView {

    private static final String PRINT_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String EXCEPTION_MESSAGE = "[ERROR] ";
    private static final String MENU_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n"
            + "[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]";
    private static final String MENU_MESSAGE_FORMAT = "[ {0} | {1} ]";
    private static final String MENU_MESSAGE_DELIMITER = " | ";
    private static final String NEXT_LINE = "\n";
    private static final String PRINT_END_MESSAGE = "\n추천을 완료했습니다.";

    public void printStart() {
        System.out.println(PRINT_START_MESSAGE);
    }

    public void printMenuMessage(MenusDto menusDto) {
        System.out.println(MENU_MESSAGE);
        System.out.println(generateMenusMessage(menusDto.getMenus()));
    }

    private String generateMenusMessage(List<MenuDto> menus) {
        return menus.stream()
                .map(menuDto -> format(MENU_MESSAGE_FORMAT, menuDto.getName(), generateMenuMessage(menuDto.getMenu())))
                .collect(Collectors.joining(NEXT_LINE));
    }

    private String generateMenuMessage(List<String> menu) {
        return String.join(MENU_MESSAGE_DELIMITER, menu);
    }

    public void printEnd() {
        System.out.println(PRINT_END_MESSAGE);
    }

    public void printExceptionMessage(String message) {
        System.out.println(EXCEPTION_MESSAGE + message);
    }
}
