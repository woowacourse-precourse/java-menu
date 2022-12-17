package menu.view;

import menu.domain.Coach;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    public void notifyStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void notifyResultNotice() {
        System.out.println("메뉴 추천 결과입니다.");
    }

    public void printCategories(List<String> categories) {
        categories.add(0, "카테고리");
        String output = output(categories);
        System.out.println(output);
    }

    public void printMenus(List<String> menus, Coach coach) {
        menus.add(0, coach.getName());
        String output = output(menus);
        System.out.println(output);
    }

    public void printDay() {
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    public void printEnd() {
        System.out.println("추천을 완료했습니다.");
    }


    public String output(List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String string : list) {
            stringBuffer.append(string);
            stringBuffer.append(" | ");
        }
        String string = addBracket(stringBuffer.toString());

        return string;
    }

    public String sperateByDelimiter(StringBuffer stringBuffer){
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (int index = 0; index < stringBuffer.length(); index++) {
            stringJoiner.add(String.valueOf(stringBuffer.charAt(index)));
        }
        return stringJoiner.toString();
    }

    public String addBracket(String string) {
        return "[ "+ string + " ]";
    }
}
