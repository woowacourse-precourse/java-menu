package menu.service;

import menu.domain.Categories;
import menu.domain.Category;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InitService {

    public void init() {
        Category one = new Category("일식", plusOne());
        Category two = new Category("한식", plusTwo());
        Category three = new Category("중식", plusThree());
        Category four = new Category("아시안", plusFour());
        Category five = new Category("양식", plusFive());

        Categories.addCategory(one);
        Categories.addCategory(two);
        Categories.addCategory(three);
        Categories.addCategory(five);
        Categories.addCategory(four);

    }

    private List<String> plusOne() {
        return preprocessFood("규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼");
    }

    private List<String> plusTwo() {
        return preprocessFood("김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음");
    }

    private List<String> plusThree() {
        return preprocessFood("깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채");
    }

    private List<String> plusFour() {
        return preprocessFood("팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜");
    }

    private List<String> plusFive() {
        return preprocessFood("라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니");
    }

    private List<String> preprocessFood(String value) {
        return Arrays.stream(value.split(", ")).collect(Collectors.toList());
    }
}
