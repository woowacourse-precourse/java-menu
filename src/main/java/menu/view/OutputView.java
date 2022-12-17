package menu.view;

import java.util.List;

public class OutputView {

    public void printResult(List<String> categories,List<String> names, List<List<String>> results) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printCategories(categories);
        printMenus(names,results);
        System.out.println("\n추천을 완료했습니다.");
    }

    public void printCategories(List<String> categories) {
        categories.add(0,"카테고리");
        System.out.println(makeResultString(categories));
    }

    public void printMenus(List<String> names, List<List<String>> results) {
        for(int i=0;i<results.size();i++){
            results.get(i).add(0,names.get(i));
            System.out.println(makeResultString(results.get(i)));
        }
    }

    public String makeResultString(List<String> values) {
        StringBuilder string = new StringBuilder();
        string.append("[ ");
        for(int i=0;i<values.size();i++){
            string.append(values.get(i));
            if (i != (values.size() - 1)) {
                string.append(" | ");
            }
        }
        string.append(" ]");
        return string.toString();
    }
}
