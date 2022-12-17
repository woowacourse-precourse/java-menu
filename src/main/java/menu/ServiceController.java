package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServiceController {
    private static final int DAY = 5;

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    InputException inputException = new InputException();
    List<ServiceModel> serviceModel = new ArrayList<>();
    List<Category> categories = new ArrayList<>();
    List<String> selectedCategory = new ArrayList<>();

    public void runService() {
        initMenu();
        initService();
        for (int i = 0; i < DAY; i++) {
            recommandMenu();
        }
        outputView.printServiceEnd(serviceModel, selectedCategory);
    }

    public void initService() {
        outputView.printServiceStart();
        initCoach();
        initCantEatMenuList();
    }

    public void initCoach() {
        String coachNames;
        String[] coachNameList;
        outputView.printRequireCoachName();
        coachNames = inputView.readInput();
        coachNameList = coachNames.split(",");
        while (inputException.exceptionCoach(coachNameList)) {
            coachNames = inputView.readInput();
            coachNameList = coachNames.split(",");
        }
        makeServiceModel(coachNameList);
    }

    public void initCantEatMenuList() {
        String[] menuList;
        for (int i = 0; i < serviceModel.size(); i++) {
            menuList = initCantEatMenu(serviceModel.get(i));
            serviceModel.get(i).makeCantEatMenu(menuList);
        }
    }

    public String[] initCantEatMenu(ServiceModel serviceModel) {
        outputView.printRequireCantEatMenu(serviceModel.getCoachName());
        String menus = inputView.readInput();
        String[] menuList = menus.split(",");
        while (inputException.exceptionMenu(menuList)) {
            menus = inputView.readInput();
            menuList = menus.split(",");
        }
        return menuList;
    }

    public void makeServiceModel(String[] coachNames) {
        for (int i = 0; i < coachNames.length; i++) {
            ServiceModel serviceModel = new ServiceModel(coachNames[i]);
            this.serviceModel.add(serviceModel);
        }
    }

    public void initMenu() {
        categories.add(new Category("일식", "규동,우동,미소시루,스시,가츠동,오니기리,하이라이스,라멘,오코노미야끼"));
        categories.add(new Category("한식", "김밥,김치찌개,쌈밥,된장찌개,비빔밥,칼국수,불고기,떡볶이,제육볶음"));
        categories.add(new Category("중식", "깐풍기,볶음면,동파육,짜장면,짬뽕,마파두부,탕수육,토마토 달걀볶음,고추잡채"));
        categories.add(new Category("아시안", "팟타이,카오 팟,나시고렝,파인애플 볶음밥,쌀국수,똠얌꿍,반미,월남쌈,분짜"));
        categories.add(new Category("양식", "라자냐,그라탱,뇨끼,끼슈,프렌치 토스트,바게트,스파게티,피자,파니니"));
    }

    public void recommandMenu() {
        List<String> menuList = selectCategory();
        for (int i = 0; i < serviceModel.size(); i++) {
            serviceModel.get(i).makeMenu(menuList);
        }
    }

    public List<String> selectCategory() {
        int randomNumber = Randoms.pickNumberInRange(1, 5) - 1;
        String category = categories.get(randomNumber).getCategoryName();
        int duplicateCount = Collections.frequency(selectedCategory, category);
        while (duplicateCount >= 2) {
            category = categories.get(randomNumber).getCategoryName();
            duplicateCount = Collections.frequency(selectedCategory, category);
        }
        selectedCategory.add(category);
        return categories.get(randomNumber).getMenuList();
    }
}