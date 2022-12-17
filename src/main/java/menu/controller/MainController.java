package menu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Day;
import menu.domain.Days;
import menu.domain.Menu;
import menu.view.InputView;
import menu.view.OutputView;

public class MainController {

    private final List<Menu> japanese = makeJapanese();
    private final List<Menu> korean = makeKorean();
    private final List<Menu> chinese = makeChinese();
    private final List<Menu> asian = makeAsian();
    private final List<Menu> western = makeWestern();

    private final List<Category> categories = makeCategories();
    private final Days days = new Days(makeDays());

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run(){
        outputView.printStartMessage();
        outputView.printAskNames();
        Coaches coaches = makeCoaches();
    }

    private Coaches makeCoaches() {
        try{
            String coachesNames = inputView.readNames();
            return new Coaches(coachesNames);
        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return makeCoaches();
        }
    }


    private List<Menu> makeJapanese() {
        List<Menu>menus = new ArrayList<>();
        String asian = "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼";
        for(String menu : asian.split(", ")){
            menus.add(new Menu(menu));
        }
        return menus;
    }

    private List<Menu> makeKorean() {
        List<Menu>menus = new ArrayList<>();
        String asian = "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음";
        for(String menu : asian.split(", ")){
            menus.add(new Menu(menu));
        }
        return menus;
    }

    private List<Menu> makeChinese() {
        List<Menu>menus = new ArrayList<>();
        String asian = "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채";
        for(String menu : asian.split(", ")){
            menus.add(new Menu(menu));
        }
        return menus;
    }

    private List<Menu> makeAsian() {
        List<Menu>menus = new ArrayList<>();
        String asian = "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜";
        for(String menu : asian.split(", ")){
            menus.add(new Menu(menu));
        }
        return menus;
    }

    private List<Menu> makeWestern() {
        List<Menu>menus = new ArrayList<>();
        String allMenu = "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜";
        for(String menu : allMenu.split(", ")){
            menus.add(new Menu(menu));
        }
        return menus;
    }

    private List<Category> makeCategories() {
        return Arrays.asList(new Category("일식", japanese)
                , new Category("한식", korean)
                , new Category("중식", japanese)
                , new Category("아시안", asian)
                , new Category("양식", western));
    }

    private List<Day> makeDays() {
        return Arrays.asList(new Day("월요일", categories)
                , new Day("화요일", categories)
                , new Day("수요일", categories)
                , new Day("목요일", categories)
                , new Day("금요일", categories));
    }
}
