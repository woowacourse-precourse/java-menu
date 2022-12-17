package menu;

import java.util.ArrayList;
import java.util.List;

public class LunchMenuController {
    private final InputView inputView;
    private final LunchMenuService lunchMenuService;
    private List<String> names;
    private List<List<String>> results;

    public LunchMenuController(){
        this.inputView = new InputView();
        this.lunchMenuService = new LunchMenuService();
        this.names = new ArrayList<>();
        this.results = new ArrayList<>();
    }

    public void start() {
        String inputNames = inputView.readNames();
        int countPeople = countNames(inputNames);

        for(int i=0;i<countPeople;i++){
            recommendMenu();
        }
        //결과 차례대로 출력
        for(List<String> result : results){
            System.out.println("결과출력: " +result);
        }
    }

    public void recommendMenu(){
        String inputMenus = inputView.readMenus();
        List<String> recommendMenus = new ArrayList<>();
        List<String> cannotEatMenus = splitMenus(inputMenus);
        while(recommendMenus.size()<5){
            int index = recommendMenus.size();
            String randomRecommendMenu = lunchMenuService.randomRecommendMenu(index);
        }
        results.add(recommendMenus);
    }

    public List<String> splitMenus(String input){
        String[] values = input.split(",");
        List<String> cannotEatMenus = new ArrayList<>();
        for(String value : values){
            cannotEatMenus.add(value);
        }
        return cannotEatMenus;
    }
    public int countNames(String input){
        String[] values = input.split(",");
        addNames(values);
        return values.length;
    }

    public void addNames(String[] values){
        for(String value : values){
            names.add(value);
        }
    }
}
